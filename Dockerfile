FROM openjdk:8
ADD target/order-entry-cloudant-0.0.1-SNAPSHOT.jar order-entry-cloudant-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","order-entry-cloudant-0.0.1-SNAPSHOT.jar"]