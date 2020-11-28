import pandas as pd
import os
import glob
import errno

def clean(filename):

    # Read csv into a df
    df =  pd.read_csv(INPUT_DIR+filename)

    print("="*len(filename))
    print(filename)
    print("="*len(filename))
    print()

    new_column_names = {

        # Common
        'Street Address' : 'street_address',
        'Creation Date' : 'creation_date',
        'Completion Date' : 'completion_date',
        'Status' : 'status',
        'Service Request Number' : 'request_number',
        'Street Address' : 'street_address',
        'Zip Code' : 'zip_code',
        'Zip Codes' : 'zip_codes',
        'Ward' : 'ward',
        'Wards' : 'wards',
        'Location' : 'location',
        'Historical Wards 2003-2015' : 'historical_wards',
        'Community Area' : 'community_area',
        'Community Areas' : 'community_areas',
        'Census Tracts' : 'census_tracts',
        'Police District' : 'police_district',
        'Type Of Service Request' : 'request_type',
        'Latitude' : 'latitude',
        'Longitude' : 'longitude',
        'X Coordinate' : 'x_coordinate',
        'Y Coordinate' : 'y_coordinate',

        # RequestType-specific
        'Current Activity' : 'current_activity',
        'Most Recent Action' : 'most_recent_action',
        'Zip':'zip_code',
        'Ssa' : 'ssa',
        'License Plate' : 'license_plate',
        'Vehicle Color' : 'vehicle_color',
        'Vehicle Make/Model' : 'vehicle_model',
        'How Many Days Has The Vehicle Been Reported As Parked?' : 'days_parked',
        'Number Of Black Carts Delivered': 'num_of_black_carts',
        'What Type Of Surface Is The Graffiti On?' : 'graffiti_surface',
        'Where Is The Graffiti Located?' : 'graffiti_location',
        'Number Of Potholes Filled On Block' : 'potholes_filled',
        'Number Of Premises Baited' : 'premises_baited',
        'Number Of Premises With Garbage' : 'premises_with_garbage',
        'Number Of Premises With Rats': 'premises_with_rats',
        'What Is The Nature Of This Code Violation?' : 'nature',
        'If Yes, Where Is The Debris Located?' : 'debris_location',
        'Location Of Trees' : 'tree_location'

    }

    # Output filenames (they correspond to relation names)
    outnames={
        '311-service-requests-abandoned-vehicles.csv': 'vehicle_request.csv',
        '311-service-requests-alley-lights-out.csv': 'alley_lights_request.csv',
        '311-service-requests-garbage-carts.csv': 'garbage_request.csv',
        '311-service-requests-graffiti-removal.csv': 'graffiti_request.csv',
        '311-service-requests-pot-holes-reported.csv': 'pothole_request.csv',
        '311-service-requests-rodent-baiting.csv': 'rodent_request.csv',
        '311-service-requests-sanitation-code-complaints.csv': 'sanitation_request.csv',
        '311-service-requests-street-lights-all-out.csv': 'lights_all_request.csv',
        '311-service-requests-street-lights-one-out.csv': 'lights_one_request.csv',
        '311-service-requests-tree-debris.csv': 'tree_debris_request.csv',
        '311-service-requests-tree-trims.csv': 'tree_trim_request.csv'
    }


    # Columns that exist in all csv files
    common_columns = [
        'request_id',
        'street_address',
        'creation_date',
        'completion_date',
        'status',
        'request_number',
        'zip_code',
        'zip_codes',
        'ward',
        'wards',
        'location',
        'historical_wards',
        'community_area',
        'community_areas',
        'census_tracts',
        'police_district',
        'request_type',
        'latitude',
        'longitude',
        'x_coordinate',
        'y_coordinate']

    # Remove duplicate rows
    df = df[~df.duplicated()]

    # Rename column names to match column names in our DB
    df.columns = map(str.title, df.columns)
    df.rename(columns = new_column_names,inplace=True)

    # Drop location column [redundant]
    df.drop(columns=['location'],inplace=True)


    # Remove 'T' from dates
    df['creation_date'] = df['creation_date'].str.replace('T',' ')
    df['completion_date'] = df['completion_date'].str.replace('T',' ')

    # Applies only on './data/311-service-requests-street-lights-one-out.csv'
    df['request_type'] = df['request_type'].str.replace('Street Light Out','Street Light - 1/Out')

    # Applies only on './data/311-service-requests-pot-holes-reported.csv'
    df['request_type'] = df['request_type'].str.replace('Pot Hole in Street','Pothole in Street')

    # Filter license plates
    if 'license_plate' in df.columns:
        df['license_plate']  = df[df['license_plate'].str.len() < 10]['license_plate']


    # Change index
    df.reset_index(drop=True, inplace=True)
    df.index+=clean.start_pos

    # Increment starting position for the next call
    clean.start_pos+=df.shape[0]

    # Make index one of the columns with name 'request_id'
    df['request_id'] = df.index

    # Create csv with specific columns for this request type [i.e.: exclude common columns]
    current_df = df[df.columns[~df.columns.isin([c for c in common_columns if c != 'request_id'])]]
    current_df = current_df[['request_id']+sorted([a for a in current_df.columns.to_list() if a != 'request_id'])]
    current_df.to_csv(OUTPUT_DIR+outnames[filename],index=False,header=False,float_format='%.f')

    # Keep only common columns
    df = df[df.columns[df.columns.isin(common_columns)]]

    # Append rows to request_df
    clean.request_df = clean.request_df.append(df)


INPUT_DIR = './data/'
OUTPUT_DIR = './out/'
input_files = [f for f in os.listdir(INPUT_DIR) if f.endswith('.csv')]
input_files.remove('311-service-requests-vacant-and-abandoned-buildings-reported.csv')

# Create OUTPUT_DIR if not exist
try:
    os.makedirs(OUTPUT_DIR)
except OSError as e:
    if e.errno != errno.EEXIST:
        raise

# Delete all files in OUTPUT_DIR
for f in glob.glob(OUTPUT_DIR+'*'):
    os.remove(f)

# Produce clean csv files
clean.start_pos = 0
clean.request_df = pd.DataFrame()
for f in input_files:
    clean(f)

# Produce general request.csv
df = clean.request_df
df = df[['request_id']+sorted([a for a in df.columns.to_list() if a != 'request_id'])]
df.to_csv(OUTPUT_DIR+'request.csv',header=False,index=False,float_format='%.f')