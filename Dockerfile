FROM tomcat:10.1.28-jdk21
WORKDIR /usr/local/tomcat
COPY target/BackendTechnologies.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]