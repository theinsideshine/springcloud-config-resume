FROM openjdk:17-jdk-alpine as builder

WORKDIR /app/msvc-sections

COPY ./pom.xml /app
COPY ./msvc-sections/.mvn ./.mvn
COPY ./msvc-sections/mvnw .
COPY ./msvc-sections/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline
COPY ./msvc-sections/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=builder /app/msvc-sections/target/msvc-sections-0.0.1-SNAPSHOT.jar .
EXPOSE 8002

ENTRYPOINT ["java", "-jar", "msvc-sections-0.0.1-SNAPSHOT.jar"]