import os
import psycopg2

# Connect to an existing database
conn = psycopg2.connect("dbname=311CI user=postgres password=pass")

# Open a cursor to perform database operations
cur = conn.cursor()

DIR = './out/'
input_files = [DIR+f for f in os.listdir(DIR) if f.endswith('.csv')]

# We need to import the request table first
fname = DIR+'request.csv'
with open(fname,'rb') as f:
    relation = fname.replace(DIR,'').replace('.csv','')
    cur.execute('TRUNCATE TABLE '+relation+' CASCADE;')
    SQL = "COPY {} FROM '{}' CSV QUOTE '\"';".format(relation,os.path.abspath(fname))
    cur.execute(SQL)

# Copy every other csv to the respective PostgreSQL table
for fname in [x for x in input_files if x != DIR+'request.csv']:
    with open(fname,'rb') as f:
        relation = fname.replace(DIR,'').replace('.csv','')
        cur.execute('TRUNCATE TABLE '+relation+' CASCADE;')
        SQL = "COPY {} FROM '{}' CSV QUOTE '\"';".format(relation,os.path.abspath(fname))
        cur.execute(SQL)

# Make the changes to the database persistent
conn.commit()

# Close communication with the database
cur.close()
conn.close()