FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
COPY out/artifacts/GankDetectorBackend_jar/GankDetectorBackend.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]