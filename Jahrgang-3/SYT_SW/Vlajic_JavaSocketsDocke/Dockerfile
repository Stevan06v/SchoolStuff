FROM openjdk:8 AS build
WORKDIR /app
COPY ./SocketsJava/src/at/htlleonding/ChatServer.java .
RUN javac ChatServer.java

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/ChatServer.class .
EXPOSE 6013
CMD ["java", "ChatServer"]