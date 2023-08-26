FROM openjdk:11.0.14.1-jdk
WORKDIR /usr/local
RUN mkdir app
WORKDIR /usr/local/app
COPY ./target/AccountService-0.0.1-SNAPSHOT.jar /usr/local/app
EXPOSE 9001
ENTRYPOINT ["java","-jar","AccountService-0.0.1-SNAPSHOT.jar"]