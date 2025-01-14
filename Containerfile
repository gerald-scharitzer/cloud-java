FROM docker.io/library/eclipse-temurin:21-jre-ubi9-minimal
# TODO upgrade podman and run with --network=none
RUN mkdir /opt/app
COPY cloud-0.0.1-SNAPSHOT.jar /opt/app/cloud.jar
CMD ["java", "-jar", "/opt/app/cloud.jar"]
