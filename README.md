
** Source code is available in github on this path: https://github.com/dkTest1234/spmigration.git **


**Description:** This application is the  Stored Procedure migration to Java and MySql database.

**Key points:**

**Technical stacks** 
	-Java Version 1.8
	-Spring Boot 2.2.2.RELEASE
	-JPA
	-MySQL Database
	-Maven
	-Emmbeded Tomcat available in Spring Boot
	-Slf4j
	-Junit
	-Mokito
	-eclipse (Oxygen) IDE used for development.

**Maven Dependencies**
	- spring-boot-starter-parent - 2.2.2.RELEASE
	- spring-boot-starter-web
	- spring-boot-starter-data-jpa
	- spring-boot-starter-jdbc
	- mysql-connector-java
	- spring-boot-starter-test
	- spring-boot-maven-plugin
	
	
**SLF4j**

Note: In project folder structure under resources folder one file name as "logback.xml". It contains the logger configurations. 
	  Need to change the log file location. It will create two log file as "debug.log" and "error.log".
	  Need to change the full package name.
	  

**Stored Procedure Migration**

Stored Procedure "MONTHLY_VALIDATION_INTERVIEW" logic has been convert to Java code and simple update statement is used to update the data in the database.

It was a single sql update statement. So with the JPQL custom query it has implemented.

  
 ** As it is a maven project. Download the project and import in eclipse. **
 
 ** Install MySql Database and create the Database as WNS **
 	- In application properties file change the database user name and password
 	- Command to create the database : create database WNS:
	- Create the database table as provided
	- Insert all provided data




