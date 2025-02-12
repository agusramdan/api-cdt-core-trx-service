FROM openjdk:11
VOLUME /tmp
ADD target/app.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]