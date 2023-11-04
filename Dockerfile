FROM openjdk:11
COPY Node.java /usr/src/myapp/
WORKDIR /usr/src/myapp
RUN javac Node.java
ENTRYPOINT ["java", "Node"]
