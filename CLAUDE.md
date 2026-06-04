# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What this is

Oceanus is a **codbex Edition** — a documents-management product (upload, download, structure documents) assembled on top of the **Eclipse Dirigible** low-code platform. This repo is mostly an *assembly and packaging* project: it bundles selected Dirigible components into a runnable Spring Boot application, adds branding and a few custom UI components, and ships a Docker image / standalone jar. The bulk of the actual functionality comes from `org.eclipse.dirigible` dependencies, not from code in this repo.

It inherits from the `com.codbex.platform:codbex-platform-parent` POM, which supplies dependency versions, plugin config (formatting, license headers), and the Maven profiles used below.

## Build & run

All commands run from the repo root (`$GIT_REPO_FOLDER`).

```shell
# Fast build (skips tests, formatting, etc.) — produces application/target/codbex-oceanus-*.jar
mvn -T 1C clean install -P quick-build

# Run the standalone jar (the --add-opens flags are required)
java \
    --add-opens=java.base/java.lang=ALL-UNNAMED \
    --add-opens=java.base/java.lang.reflect=ALL-UNNAMED \
    --add-opens=java.base/java.nio=ALL-UNNAMED \
    -jar application/target/codbex-oceanus-*.jar
# add -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000 to debug on port 8000
```

App serves on `http://localhost:80`, default login `admin` / `admin`. REST API / Swagger UI at `http://localhost/swagger-ui/index.html`.

Docker (requires a built jar first):
```shell
cd application && docker build . --tag ghcr.io/codbex/codbex-oceanus:latest
```

## Tests

```shell
mvn clean install -P unit-tests          # unit tests only
mvn clean install -P integration-tests   # integration tests only (Selenium UI tests, slow)
mvn clean install -P tests               # both
```

Run a single test with the standard Surefire/Failsafe selector, e.g.:
```shell
mvn clean install -P integration-tests -Dit.test=HomePageIT
mvn clean install -P unit-tests -Dtest=SomeTest
```

Integration tests live in `integration-tests/` and extend `OceanusIntegrationTest` (which extends Dirigible's `UserInterfaceIntegrationTest` — they drive a real browser). `DirigibileCommonTestSuiteIT` runs Dirigible's shared platform test suite against this edition.

## Formatting

```shell
mvn verify -P format
```
Code style and license headers are enforced via the parent POM; run this before committing. CI also runs CodeQL and the codbex shared platform pull-request workflow.

## Spring profiles

The app is a Spring Boot application. To activate Eclipse Dirigible you must explicitly include the `common` and `app-default` profiles. Example (Snowflake):
```
SPRING_PROFILES_ACTIVE=common,snowflake,app-default
```

## Module layout

This is a multi-module Maven build (`pom.xml` lists the modules):

- **`application/`** — the deployable Spring Boot app. `OceanusApplication.java` is the entry point; it `scanBasePackages` over `org.eclipse.dirigible` and excludes the JDBC/JPA auto-configurations (Dirigible manages datasources itself). The chosen feature set is defined by which `dirigible-components-*` dependencies are declared in `application/pom.xml` — this is the main place where the product's capabilities (CMS engines, security providers like basic/keycloak/cognito/snowflake, SFTP, APIs, UI) are turned on. Also contains the Dockerfile and `application*.properties` / `dirigible.properties`.
- **`branding/`** — overrides Dirigible's default branding (name, logos, etc.).
- **`components/`** — custom Dirigible components for this edition. Each is packaged as resources under `src/main/resources/META-INF/dirigible/...` (e.g. `components/ui/menu-help` provides menu extensions, translations, and config — not Java code). New product-specific UI/extensions go here following the same `META-INF/dirigible` resource convention.
- **`integration-tests/`** — browser-driven integration tests; not shipped.

## Working in this repo

- To change *what features the product includes*, edit dependencies in `application/pom.xml` (add/remove `dirigible-components-*` modules). Behavior usually comes from the Dirigible dependency, not local code.
- To add custom UI/menu/extension content, add a module under `components/` mirroring the `menu-help` resource structure and register it in the parent POM modules + `dependencyManagement`.
- Versions of `org.eclipse.dirigible` and most third-party libs are managed by `codbex-platform-parent` — bump the parent version rather than pinning versions here.
