###Report System
Technology Architectire:SpringBoot(Embedded Tomcat) + mybatis + mysql + layui

#### Source Code
Download Link: https://github.com/cityu-ds-hk/report  
Code Compile: mvn clean package (switch to root path of project)  

#### Mysql Database
IP: 167.179.96.232  
Port: 3306  
User: root  
Password: 123456  

#### Deploy
Environment: jdk8  
Command: java -jar report.jar edu.cityu.ds.report.ReportApplication > report.log 2>&1
Log File: The log data input to report.log file.  
Access Link: http://localhost:8080/

