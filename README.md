# crispy-bassoon
Simple sandwich store

Requisitos
- [Maven](https://maven.apache.org/install.html)
- [Docker] (https://store.docker.com/editions/community/docker-ce-server-ubuntu) 
- [Docker compose] (https://docs.docker.com/compose/install/)

Para rodar o projeto *sem* Docker

`mvn spring-boot:run`

O projeto estará disponível em http://localhost:8080

Para rodar o projeto *com* Docker

`mvn clean install`

`docker-compose build .`

`docker-compose up`

O projeto está disponível em http://localhost
