FROM openjdk:17
ADD target/lms.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]