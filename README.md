# How to run application

## Requirements
1. Java JDK 11 (i used amazon corretto wersion 11.0.11)
2. MySql Server with full root account (I used 8.0.26 Mysql Community server - GPL)
3. Postman or other environment to use GET endpoint
4. Ide, preferred Intellij IDEA

### Steps

1. Clone project from: asd and trust to project
2. Build project with maven (if you have Intellij IDEA expand Maven bookmark on the right side and use button to Reload All Maven Projects)
3. In the project structure open src -> main -> resources -> application.properties and put login and password to your database
4. Open resources -> database -> create-tables.sql to create database structure
5. In src -> main -> java -> com.example.jsonparser -> service -> MainService.java on line 22 (variable FILE_PATH) put full path to file which you want import data. Remember, use correct path format:
<br>a) Windows double slash -> \\
<br>b) Linux use single slash -> /
6. Open src -> main -> java -> com.example.jsonparser -> JsonparserApplication.java and run project use green rectangle on the left or click RPM to field with code and click Run 'JsonparserApplication'
   Application should have all permisions to read data.

### Most common problems
1. Caused by: org.hibernate.service.spi.ServiceException: Unable to create requested service [org.hibernate.engine.jdbc.env.spi.JdbcEnvironment]
Solve: Wrong database login, password or url
2. I can't run application
<br>Solve:
<br>a) check pom.xml file. Icon M should be blue if is not you have to add maven framework to project (wrong cloned project). On the head of project structure click right mouse button (to project name 'jsonparser') -> Add framework support -> find and check Maven then click ok
<br>b) Code highlighted in red in each classes -> probably you forgot choose JDK. On the top left click File -> Project structure... -> Project -> Project SDK and here you have to choose Java version and apply.
<br>c) Try Reload all Maven projects and build project with maven. If you have installed Maven locally, open Intellij terminal and run 'mvn clean install -DskipTests' or run command from Maven Bookmark

