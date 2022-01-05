FROM openjdk:8
ADD target/order-entry-cloudant.jar order-entry-cloudant.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","order-entry-cloudant.jar"]