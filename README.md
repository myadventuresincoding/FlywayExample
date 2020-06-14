# Flyway Example
Simple Flyway schema version example in Java


## Prerequisites
If you already have SQL server, great! However, if you do not you can download and install SQL Express.

* Download [SQL Server Express](https://www.microsoft.com/en-us/sql-server/sql-server-downloads)
* Download [SQL Server Management Studio](https://docs.microsoft.com/en-us/sql/ssms/download-sql-server-management-studio-ssms?view=sql-server-ver15)

## Create Database
To create the database and user used by this application you will need to run the following script in SSMS:

* /src/main/resources/db/create/Create_Database_and_User.sql

## Run the Application
If you have IntelliJ or Eclipse you can open the pom.xml file and run the application.

However, if you have [Maven](https://maven.apache.org/download.cgi) installed you can run the application from the command line with:
* mvn compile
* mvn exec:java -Dexec.mainClass="FlywayExample"

When Flyway runs it will apply the following migration script:

* /src/main/resources/db/migration/V1_0_0_1__create_tables.sql

## Verify
After the application has run you should have two new tables:

* dbo.Person - Created by our migration script
* dbo.schema_version - Created by Flyway to track schema version

You can look at the result of the scripts run by Flyway with the query:

* SELECT * FROM dbo.schema_version;