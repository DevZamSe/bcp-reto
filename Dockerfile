FROM java:8

COPY /target/tipo-cambio.jar tipo-cambio.jar

EXPOSE 80

ENTRYPOINT ["java", "-jar", "tipo-cambio.jar"]
