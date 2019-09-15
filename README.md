# food-database-search-app


## Run application
`docker-compose up`

### Notes
To keep things a little easier to view. I put everything in this single repository, instead of creating individual repositories for each service as you would commonly see for larger production applications. 

Some things I would have liked to do given more time. 
- Add better linting to project
    - Update tslint rules
    - Add Checkstlye or sonarlint
- Add ci/cd pipeline
- Add infrastructure jobs
- Increase code coverage to 100% 
- Extract properties files to AWS
    - Create properties files for each environment
    - Store those in s3
- Add UI styling
- Optimize database queries. 
    - explained below. 
- Add security to UI and backend, as it is currently wide open. 
    - HTTPS
    - Fine grain cors policy
    - Oauth or other auth server
    - more restrictive AWS security groups for the ec2 instance and RDS server. 

An alternative approach i considered for the database. 
Since this tool is only querying data, you could create a view of the data using something like elasticsearch. 
This would give us much more powerful tools for searching the data (Autocomplete, faster responses, Addtional security, etc) while retaining the redundancy and safety of an ACID compliant database. 

This would look something like the following

source data -> spark transformations -> postgres/s3

postgres/s3 -> additional spark transformations -> elasticsearch

#### ETL

I decided to clean up the data a little bit before ingesting it into the database. For this I used spark and databricks.

I performed some etl processes on the data to get it into an easily accessible state.
To perform these operations i used a Databricks cluster i own. 
I just submitted this as a notebook. In production, this would have it's own repository, and its own unit tests. and infrastructure for job scheduling, etc. 

Steps performed:
1. Manually upload datasets into datastore as tables (nutrimedy.nutrients, nutrimedy.products, etc ). 
2. Perform transformation in `etl/product-etl.scala` on the datasources. 


This allowed me to structure the data in a way that the application does not need to make mutiple endpoint calls, and the data is formatted in a nice consumable object


#### Testing
I wrote a few tests for the backend. I was a little unsure about testing the ETL and the UI as the challenge details only specified unit tests for the backend. In a normal production application, i would have strived for 100% coverage on all of this and would have most likely done TDD, and written the tests before the application code. If it is preferred, I could add tests for the frontend and ETL. 

#### Infrastructure
I used the following to host the application

AWS RDS for the Postgres database
Databricks hosted on AWS for the etl. 
AWS EC2 to host the application. 

To speed things up, I had manually created all of the stack and policies involved for this project. Given more time, i would have liked to setup a ci/cd pipeline, and create all of the infrastructe as code. 


