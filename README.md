# cinema_project
REST API solution for cinema project


Requirements to run the project:
Java 17
Maven (optional)

Steps:
1. git clone https://github.com/simonbucko/cinema_project.git
2. create a database schema on your local MySQL Server
3. set up an environment variable to replace the ${DATABASE_URL} variable in the application-dev.properties
4. *something like this: jdbc:mysql://localhost:3306/<schema_name>?username=<your_db_username>&password=<your_db_password>
5. when you are running the project for the first time undo the comment line on the @Configuration annotation located in cinema.shows.configurations.DataBootstrap
6. *this will create some data in your newly created schema 
7. *make sure to comment out the @Configuration annotation after the first run or else you will encounter some sql exceptions
8. if you are running your project from your IDE you can start the application
9. if you are running maven: $ mvn compile, $ mvn install, $ mvn spring-boot:run -P dev
