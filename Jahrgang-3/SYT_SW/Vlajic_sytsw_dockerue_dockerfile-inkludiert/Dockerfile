FROM node:18-alpine

MAINTAINER stevanvlajic5@gmail.com

WORKDIR /app

COPY ./vlajic-themenseite .

RUN npm install

EXPOSE 3000

CMD node server.js