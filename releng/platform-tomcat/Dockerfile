# Docker descriptor for codbex
# License - http://www.eclipse.org/legal/epl-v20.html

FROM tomcat:9.0.56-jre11-openjdk

COPY target/ROOT.war $CATALINA_HOME/webapps/
RUN unzip $CATALINA_HOME/webapps/ROOT.war -d $CATALINA_HOME/webapps/ROOT
RUN rm $CATALINA_HOME/webapps/ROOT.war

RUN rm /usr/local/tomcat/conf/tomcat-users.xml
RUN wget  http://www.dirigible.io/help/conf/tomcat-users.xml -P /usr/local/tomcat/conf/ --no-check-certificate

RUN wget https://repo1.maven.org/maven2/org/postgresql/postgresql/42.1.4/postgresql-42.1.4.jar -P /usr/local/tomcat/lib/

ENV DIRIGIBLE_JAVASCRIPT_GRAALVM_DEBUGGER_PORT=0.0.0.0:8081
