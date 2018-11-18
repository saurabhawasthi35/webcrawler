Authors:- Saurabh Awasthi

Project Title
This Project used to web crawling the URL in same domain, it should visit all pages within the domain, but not follow the links to external sites such as Google or Twitter etc.
Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project.
Name of release Module(s)     : WebCrawler
Package name                        : webcrawler
Prerequisites
Below are the list which required to deploy or install the project.
Java Version:- JDK 8
Maven:- apache-maven-3.5.4
Testing Tool :- PostMan or Poster or RestClient any of the tool required to test the usecase.
Server :- Tomcat 7
Set the Environment variable for java, Tomcat and maven in Window/Linux machine
Link to download the software
JAVA 8:- https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
Maven:- https://maven.apache.org/download.cgi
PostMan :- https://www.getpostman.com/apps
Tomcat:- https://tomcat.apache.org/download-70.cgi
Installing/Building 
Step to install the project
1-	Download the Project from the given GITHUB directory.
2-	Go to master directory of project i.e. <Local_System_Directory>/webcrawler and run the command mvn clean install
 
3-	If the command running first time it will download all required and its dependent JAR from maven repository.
4-	Success definition of build means project compile successfully and all the JUNIT test execute successfully.
 

Deployment 

Step to deploy war in Tomcat server
 
1-	Copy the .war file (E.g.: prj.war) to %CATALINA_HOME%\webapps ( E.g.: C:\tomcat\webapps )
2-	Run %CATALINA_HOME%\bin\startup.bat
3-	Your .war file will be extracted automatically to a folder that has the same name (without extension) (E.g.: prj)
4-	Go to %CATALINA_HOME%\conf\server.xml and take the port for the HTTP protocol. <Connector port="8080" ... />. The default value is 8080.
5-	Success definition of deploy will be if the war entry present in server.xml file
 


Running the UseCase
Step to run the test case, 
1-	Open the Postman tool
2-	Type the below URL to run use case
http://<IPAddress>:<PORT>/webcrawler/restwebcrawler/webcrawlerservice/getWebCrawlerList/
3-	As the request is POST. Hence select the POST option from dropdown
4-	Select the Headers opti0n as Content-Type: application/json
  
5-	Provide the Post request input like
{
	"url":"http://www.<DOMAIN_NAME>.com"
} 
6-	Click on Send button.


