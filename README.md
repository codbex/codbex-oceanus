# codbex-oceanus

Oceanus Edition contains documents management standard components.

It is good for uploading, downloading and structuring documents.

### Docker

```
docker pull ghcr.io/codbex/codbex-oceanus:latest
docker run --name codbex-oceanus --rm -p 80:80 ghcr.io/codbex/codbex-oceanus:latest
```

#### Build

```
mvn clean install
```
	
#### Run

```
java -jar application/target/codbex-oceanus-application-*.jar
```

#### Debug

```
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000 -jar application/target/codbex-oceanus-application-*.jar
```

#### Web

```
http://localhost
```

#### REST API

```
http://localhost/swagger-ui/index.html
```
