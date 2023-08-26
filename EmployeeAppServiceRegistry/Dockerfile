FROM openjdk:11.0.14.1-jdk
WORKDIR /usr/local
RUN mkdir app
WORKDIR /usr/local/app
COPY ./target/EmployeeAppServiceRegistry-0.0.1-SNAPSHOT.jar /usr/local/app
EXPOSE 8761
ENTRYPOINT ["java","-jar","EmployeeAppServiceRegistry-0.0.1-SNAPSHOT.jar"]