# cinema_project
 
## Overview :
REST API solution for cinema project, third semester KEA

### REST overview:
http://localhost:8080/swagger-ui/index.html#/

## Project Descriptio
...

In this project we will use:
<ol>
  <li>Java 17</li>
  <li>Maven</li>
  <li>Other tools: Git, Postman</li>
 </ol>
 
 ## Steps
  <ol>
  <li>git clone https://github.com/simonbucko/cinema_project.git</li>
  <li>create a database schema on your local MySQL Server</li>
  <li>set up an environment variable named <b>${DATABASE_URL}</b> which represents the credentials to connect to the database.
   <br>*in our project it is declared in the <b>application.properties</b> file which spring boot reads before running the program.
   <br>*example: <b>jdbc:mysql://localhost:3306/your_schema_name?username=your_db_username&password=your_db_password</b>
  <li>if you are running your project from your IDE you can start the application once you set up the variable</li>
      *if you are running maven: $ mvn compile, $ mvn install, $ mvn spring-boot:run -P dev
 </ol>
 
Group BBH:
1. Vlad Chivu: 
   1. implemented the CRUD Service for Movies, Movies Playing and Shows
   2. REST for Movies, Movies playing and Shows
2. Simon Bucko: 
   1. Implemented REST test for MovieRESTImp
   2. Worked creating on ticketing part
   3. partially helped on implementing detailed version of the movie resource
3. Vlad Garau:
   1. Worked on implementing detailed information about a movie
   2. Added DTO layer for our movie

 
