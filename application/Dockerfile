FROM amazoncorretto:25-alpine

VOLUME /tmp

RUN apk update && \
    apk add --no-cache

RUN apk add nodejs npm
RUN npm i -g typescript

COPY target/codbex-oceanus-[0-9]*.jar codbex-oceanus.jar
ENTRYPOINT ["java", "--add-opens", "java.base/java.lang=ALL-UNNAMED", "--add-opens", "java.base/java.lang.reflect=ALL-UNNAMED", "--add-opens", "java.base/java.nio=ALL-UNNAMED", "-jar", "/codbex-oceanus.jar"]
EXPOSE 80 8081
