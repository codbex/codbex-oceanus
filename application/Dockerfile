FROM amazoncorretto:21-alpine

VOLUME /tmp

RUN apk update && \
    apk add --no-cache

RUN apk add nodejs npm
RUN npm i -g typescript

COPY target/codbex-oceanus-[0-9]*.jar codbex-oceanus.jar
# PropertiesLauncher (not -jar / JarLauncher) so AOT-compiled module jars dropped into /modules
# join the classpath (eclipse-dirigible/dirigible#6592). A missing or empty /modules is ignored.
ENTRYPOINT ["java", "--add-opens", "java.base/java.lang=ALL-UNNAMED", "--add-opens", "java.base/java.lang.reflect=ALL-UNNAMED", "--add-opens", "java.base/java.nio=ALL-UNNAMED", "-cp", "/codbex-oceanus.jar", "-Dloader.path=/modules", "org.springframework.boot.loader.launch.PropertiesLauncher"]
EXPOSE 80 8081
