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
It is also the number two of [The Top Programming Languages 2024](https://spectrum.ieee.org/top-programming-languages-2024)
of [IEEE Spectrum](https://spectrum.ieee.org/)
and its top non-interpreted language.

## Cloud-Native

The relevant artifacts can be addressed with URIs.

| artifact | purl type | endpoint         | usage                                              |
|----------|-----------|------------------|----------------------------------------------------|
| source   | github    | Git repository   | `git clone https://githost/git-repository`         |
| library  | maven     | Maven repository | `implementation("group:name:version)`              |
| builder  |           | Paketo builder   | `pack build image -B builder-repository`           |
| image    | oci       | image registry   | `podman push https://imagehost/image-repository`   |
| chart    | helm      | chart registry   | `helm push chart https://charthost/chart-registry` |
| cluster  |           | Kubernetes API   | `kubectl login https://kubehost/kube-api`          |

- [purl types](https://github.com/package-url/purl-spec/blob/master/PURL-TYPES.rst)
- [Git repository](https://git-scm.com/book/en/v2/Git-on-the-Server-The-Protocols)
- [Maven repository](https://maven.apache.org/repository/layout.html)
- [Paketo builder](https://paketo.io/docs/concepts/builders/)
- [OCI image registry](https://opencontainers.org/release-notices/overview/)
- [chart registry](https://helm.sh/docs/topics/registries/)
- [Kubernetes API](https://kubernetes.io/docs/reference/using-api/api-concepts/)

## Kubernetes Jobs

[run to completion](https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/)
and [restart either `Never` or `OnFailure`](https://kubernetes.io/docs/concepts/workloads/controllers/job/#pod-template).
You must specify the `restartPolicy`.

They run to completion once, if you do not set `spec.completions.`
They run one pod at a time, if you do not set `spec.parallelism`.

`helm install` works, if the job name does not exist.
Then, it will try to run to completion once.

`helm upgrade` without changing the chart or values does not change the completions
and thus does not start a new pod.

Incrementing the `completions` by one starts a new pod.
This must deal with concurrent updates,
which can be done with version control like Git.

To address the jobs matching the completions, set the `completionMode` to `Indexed`.
Then the job index is the completion number minus one.

**TODO** Does changing the chart or values start a new pod? Probably not.

# Develop

with the following tools

- [Java](https://adoptium.net/installation/) 21
- [Spring Boot](https://docs.spring.io/spring-boot/system-requirements.html) 3.4
- [Gradle](https://docs.gradle.org/current/userguide/installation.html) 8
- [Podman](https://podman.io/docs/installation)
- [Helm](https://helm.sh/docs/intro/install/) 3
- [Kubernetes](https://kubernetes.io/docs/setup/)

and the following commands.

- Run with `./gradlew bootRun [--args='<arguments>']`
- Pack with `./gradlew bootJar`
- Run package with `java -jar build/libs/cloud-<version>.jar <arguments>`
- Build image with `. sh/build-image.sh`
- Run container with `podman run -t cloud-java`
- Remove container with `podman rm <container>`
- Login to registry with `podman login <registry>`
- Push image with `podman push <image>`
- Logout from registry with `podman logout <registry>`
- Lint chart with `. sh/lint-chart.sh`
- Render chart with `. sh/render-chart.sh`
- Dry-run chart with `. sh/dry-run-chart.sh`
- Install chart with `. sh/install-chart.sh`
- Uninstall release with `. sh/uninstall-release.sh`
- Remove image with `. sh/remove-image.sh`
- Clean with `./gradlew clean`

where
- `<arguments>` are the command line arguments
- `<container>` is the name or ID of the container
- `<image>` is the name of the image
- `<registry>` is the name of the image registry
- `<version>` is the semantic version

## Release

- Update year in [`LICENSE`](LICENSE)
- Increment version in
  - [`build.gradle.kts`](build.gradle.kts)
  - [`Containerfile`](Containerfile)
  - [`helm/cloud/Chart.yaml`](helm/cloud/Chart.yaml)
  - [`sh/build-image.sh`](sh/build-image.sh)

# Known Issues

Reading `stdin` does not work from task `./gradlew bootRun --args='i' <stdin.yaml`,
but `java -jar build/libs/cloud-<version>.jar i <stdin.yaml` works.

# Backlog

- Build with paketo.
- Convert shell scripts to yaml and custom Gradle task.
