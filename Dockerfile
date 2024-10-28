# Use an official Tomcat image as the base
FROM tomcat:9.0

#COPY target/vulnerable-java-app.war /usr/local/tomcat/webapps/

COPY target/vulnerable-java-app-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/vulnerable-java-app.war

# Expose the default Tomcat port
EXPOSE 8080

# Start Tomcat server
CMD ["catalina.sh", "run"]

