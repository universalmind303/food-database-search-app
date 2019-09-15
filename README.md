# food-database-search-app


## Run application
`docker-compose up`

### Notes
To keep things a little easier to view. I put everything in this single repository, instead of creating individual repositories for each service as you would commonly see for larger production applications. 

Some things I would have liked to do given more time. 
- Add better linting to project
- Add ci/cd pipeline
- Add infrastructure jobs
- Increase code coverage to 100% 
- Extract properties files to AWS, or other external source. 
- Add UI styling

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


