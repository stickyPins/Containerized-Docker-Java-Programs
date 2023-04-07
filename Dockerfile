#base image
FROM openjdk

COPY . /src/java
WORKDIR /src/java
RUN ["javac", "Email.java"]

ENTRYPOINT ["java", "Email"]