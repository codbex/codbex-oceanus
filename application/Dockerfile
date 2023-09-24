FROM amazoncorretto:20
VOLUME /tmp
COPY target/*.jar codbex-oceanus.jar
ENTRYPOINT ["java", "java","--add-opens", "java.base/java.lang=ALL-UNNAMED", "--add-opens", "java.base/java.lang.reflect=ALL-UNNAMED", "--add-opens", "java.base/java.nio=ALL-UNNAMED", "-jar", "/codbex-oceanus.jar"]
EXPOSE 80 22
