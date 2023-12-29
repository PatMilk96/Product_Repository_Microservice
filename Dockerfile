FROM openjdk:19
WORKDIR /app
COPY target/Product_Repository_Microservice-0.0.1-SNAPSHOT.jar /app
EXPOSE 8081
CMD ["java", "-jar", "Product_Repository_Microservice-0.0.1-SNAPSHOT.jar"]