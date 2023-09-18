FROM ubuntu:latest 
MAINTAINER stevanvlajic5@gmail.com

RUN apt-get update 
RUN apt full-upgrade -y
RUN apt-get install -y apache2

COPY index.html /var/www/html

EXPOSE 80

ENTRYPOINT ["/var/www/html", "-g", "daemon off;"]