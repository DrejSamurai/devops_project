FROM maven:3.8-jdk-11-slim as builder

ARG build_dir=/tmp/build
WORKDIR /tmp/build
COPY pom.xml .
RUN mvn -Dmaven.repo.local=$build_dir dependency:go-offline
COPY src/ ./src/
RUN mvn -Dmaven.repo.local=$build_dir -DskipTests package

FROM openjdk:11-jre-slim
ARG build_dir=/tmp/build


COPY --from=builder --chown=nobody:nogroup $build_dir/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8888