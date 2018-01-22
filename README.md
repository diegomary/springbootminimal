This project requires Maven 3 to be installed and it generates a war file that can be directly deployed to Apache Tomcat.

Type mvn package to build the project.

Type  mvn spring-boot:run to run the project.

Alternatively installing Apache TomCat, it is possible to deploy the generated war file on the web server


Note: the Tymeleaf View engine has been installed.

In order to shut down the application just do the following:

curl -X POST localhost:8090/shutdown

This Application generates a war file that can be deployed in Tomcat 8
