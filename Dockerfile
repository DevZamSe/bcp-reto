FROM java:8

COPY /target/tipo_cambio.jar tipo_cambio.jar

EXPOSE 80

ENTRYPOINT ["java", "-jar", "tipo_cambio.jar"]
