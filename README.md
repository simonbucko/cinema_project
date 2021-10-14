# cinema_project
 
## Overview :
REST API solution for cinema project, third semester KEA

## Project Description
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
 <li>set up an environment variable to replace the <b>${DATABASE_URL}</b> variable in the <b>application-dev.properties</b></li>
      *something like this: jdbc:mysql://localhost:3306/<schema_name>?username=<your_db_username>&password=<your_db_password>
      <br/>
      *if you're using IntelliJIDEA you can set that from <Edit Configuration>
  <li>when you are running the project for the first time undo the comment line on the <b>@Configuration</b> annotation located in        <b>cinema.shows.configurations.DataBootstrap</b></li>
      *this will create some data in your newly created schema
      <br/>
 *make sure to <b>comment out</b> the @Configuration annotation after the first run or else you will encounter some sql exceptions
  <li>if you are running your project from your IDE you can start the application</li>
      *if you are running maven: $ mvn compile, $ mvn install, $ mvn spring-boot:run -P dev
 </ol>
 

 
