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
        'Street Address',
        'Creation Date',
        'Completion Date',
        'Status',
        'Service Request Number',
        'Street Address',
        'Zip Code',
        'Zip Codes',
        'Ward',
        'Wards',
        'Location',
        'Historical Wards 2003-2015',
        'Community Area',
        'Community Areas',
        'Census Tracts',
        'Police District',
        'Type Of Service Request',
        'Latitude',
        'Longitude',
        'X Coordinate',
        'Y Coordinate'
    ]

    # Remove duplicate rows
    df = df[~df.duplicated()]

    # Rename zip column (applies only on '311-service-requests-pot-holes-reported.csv')
    df.rename(columns = {'ZIP':'Zip Code'},inplace=True)

    # Change header case (in some .csv files header is uppercased)
    df.columns = map(str.title, df.columns)

    # Remove 'T' from dates
    df['Creation Date'] = df['Creation Date'].str.replace('T',' ')
    df['Completion Date'] = df['Completion Date'].str.replace('T',' ')

    # Applies only on './data/311-service-requests-street-lights-one-out.csv'
    df['Type Of Service Request'] = df['Type Of Service Request'].str.replace('Street Light Out','Street Light - 1/Out')

    # Applies only on './data/311-service-requests-pot-holes-reported.csv'
    df['Type Of Service Request'] = df['Type Of Service Request'].str.replace('Pot Hole in Street','Pothole in Street')

    # Change index
    df.reset_index(drop=True, inplace=True)
    df.index+=clean.start_pos

    # Increment starting position for the next call
    clean.start_pos+=df.shape[0]

    # Create csv with specific columns for this request type [i.e.: exclude common columns]
    current_df = df[df.columns[~df.columns.isin(common_columns)]].sort_index(axis=1)
    current_df .to_csv(OUTPUT_DIR+outnames[filename],header=False,sep='\t',float_format='%.f')

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
clean.request_df.sort_index(axis=1,inplace=True)
clean.request_df.to_csv(OUTPUT_DIR+'request.csv',header=False,sep='\t',float_format='%.f')