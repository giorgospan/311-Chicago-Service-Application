#!/usr/bin/env python
# coding: utf-8

import pandas as pd
import os

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
        '311-service-requests-garbage-carts.csv': 'garbage_request.csv.csv',
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
        'Creation Date',
        'Completion Date',
        'Status',
        'Service Request Number',
        'Street Address',
        'Zip Code',
        'Zip Codes',
        'Ward',
        'Wards',
        'Historical Wards 2003-2015',
        'Community Area',
        'Community Areas',
        'Census Tracts',
        'Police District',
        'Point',
        'Location',
        'Type Of Service Request'
    ]
    
    # Remove duplicate rows
    df = df[~df.duplicated()]

    # Rename zip column (applies only on '311-service-requests-pot-holes-reported.csv')
    df.rename(columns={'ZIP': 'Zip Code'},inplace=True)
    
    # Change header case (in some .csv files header is uppercased)
    df.columns = map(str.title, df.columns)
    
    # Remove 'T' from dates
    df['Creation Date'] = df['Creation Date'].str.replace('T',' ')
    df['Completion Date'] = df['Completion Date'].str.replace('T',' ')
   
    # Create 'Point' column from X,Y
    df['Point'] = ['('+str(x)+','+str(y)+')'for (x,y) in zip(df['X Coordinate'],df['Y Coordinate'])]
    df['Point'] = df['Point'].str.replace('(nan,nan)','',regex=False)
    df.drop(columns=['X Coordinate','Y Coordinate'],inplace=True)
    
    # Create 'Location' column from lat,long
    df['Location'] = ['POINT('+str(lat)+' '+str(long)+')'for (lat,long) in zip(df['Latitude'],df['Longitude'])]
    df['Location'] = df['Location'].str.replace('POINT(nan nan)','',regex=False)
    df.drop(columns=['Latitude','Longitude'],inplace=True)

    # Applies only on './data/311-service-requests-street-lights-one-out.csv'
    df['Type Of Service Request'] = df['Type Of Service Request'].str.replace('Street Light Out','Street Light - 1/Out')

    # Applies only on './data/311-service-requests-pot-holes-reported.csv'
    df['Type Of Service Request'] = df['Type Of Service Request'].str.replace('Pot Hole in Street','Pothole in Street')
    
    # Create csv with specific columns for this request type [i.e.: exclude common columns]
    df[df.columns[~df.columns.isin(common_columns)]].to_csv(OUTPUT_DIR+outnames[filename],header=False,sep='\t',float_format='%.f')
    
    # Keep only common columns
    df = df[df.columns[df.columns.isin(common_columns)]]
    
    # Change index
    df.reset_index(drop=True, inplace=True)
    df.index+=clean.start_pos
    
    # Increment starting position for the next call
    clean.start_pos+=df.shape[0]
    
    # Append rows to request_df
    clean.request_df = clean.request_df.append(df)

INPUT_DIR = './data/'
OUTPUT_DIR = './out/'

input_files = [f for f in os.listdir(INPUT_DIR) if f.endswith('.csv')]
clean.start_pos = 0
clean.request_df = pd.DataFrame()

for f in input_files:
    clean(f)
clean.request_df.to_csv(OUTPUT_DIR+'request.csv',header=False,sep='\t',float_format='%.f')

import psycopg2

# Connect to an existing database
conn = psycopg2.connect("dbname=311CI user=postgres password=pass")

# Open a cursor to perform database operations
cur = conn.cursor()

# Truncate table
cur.execute('TRUNCATE TABLE test;')

# Copy csv to PostgreSQL table
with open('./out/test.csv','rb') as f:
    print(cur.copy_from(f, 'test',null=''))

# Make the changes to the database persistent
conn.commit()

# Close communication with the database
cur.close()
conn.close()

