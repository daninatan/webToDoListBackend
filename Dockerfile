FROM openjdk:17-jdk-slim
COPY out/artifacts/to_do_list_jar/to_do_list.jar /app/to_do_list.jar
ENTRYPOINT ["java", "-jar", "/app/to_do_list.jar"]

