# Cloud Computing with Java

started with https://start.spring.io/ and

- Project: Gradle - Kotlin
- Language: Java
- Spring Boot: 3.4.0
- Packaging: Jar
- Java: 21

# Rationale

The "Cloud" is a diverse set (graph) of computers (nodes)
with communication links (edges).

One and the same Java bytecode can run on nodes with different processor,
system, and operating system architectures,
as long as there is a compliant Java Virtual Machine (JVM) implementation.

The Just-in-Time compiler (JIT) can optimize the bytecode for the instruction set architecture it is running on.

Java applications can communicate with the cloud through the standard library
and an ecosystem of public Java libraries.

Java is the most energy- and time-efficient, non-compiled programming language
in the study [Energy Efficiency across Programming Languages](https://sites.google.com/view/energy-efficiency-languages)
published in 2017.

# Develop

with the following commands.

- Run with `./gradlew bootRun [--args='<arguments>']`
- Pack with `./gradlew bootJar`
- Run package with `java -jar build/libs/cloud-<version>.jar <arguments>`
- Build image with `podman build build/libs -f Containerfile -t cloud-java:<version>`
- Run container with `podman run -t cloud-java`
- Remove container with `podman rm <container>`
- Remove image with `podman rmi cloud-java`
- Lint chart with `. sh/lint-chart.sh`
- Clean with `./gradlew clean`

where
- `<arguments>` are the command line arguments
- `<container>` is the name or ID of the container
- `<version>` is the semantic version

# Known Issues

Reading `stdin` does not work from task `./gradlew bootRun --args='i' <stdin.yaml`,
but `java -jar build/libs/cloud-<version>.jar i <stdin.yaml` works.

# Backlog

Convert shell scripts to yaml and custom Gradle task.
