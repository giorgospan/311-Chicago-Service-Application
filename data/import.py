import os
import psycopg2

# Connect to an existing database
conn = psycopg2.connect("dbname=311CI user=postgres password=pass")

# Open a cursor to perform database operations
cur = conn.cursor()

# Truncate table
cur.execute('TRUNCATE TABLE test;')

DIR = './out/'
input_files = [DIR+f for f in os.listdir(DIR) if f.endswith('.csv')]

# Copy each csv to the respective PostgreSQL table
for fname in input_files:
    with open(fname,'rb') as f:
        relation = fname.replace(DIR,'').replace('.csv','')
        print('Importing to '+relation+'...')
        print()
        cur.copy_from(f, relation,null='')

# Make the changes to the database persistent
conn.commit()

# Close communication with the database
cur.close()
conn.close()