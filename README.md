[![CircleCI](https://circleci.com/gh/cadorfo/crispy-bassoon.svg?style=svg)](https://circleci.com/gh/cadorfo/crispy-bassoon)
# Crispy-Bassoon - WebLanches

Requisitos
- [Maven](https://maven.apache.org/install.html)
- [Docker] (https://store.docker.com/editions/community/docker-ce-server-ubuntu) 
- [Docker compose] (https://docs.docker.com/compose/install/)

Para rodar o projeto **sem** Docker
```
mvn spring-boot:run
```
O projeto estará disponível em http://localhost:8080

Para rodar o projeto **com** Docker

```bash
mvn clean install

docker-compose build 

docker-compose up
``` 
ou execute script 

```bash
run-dockerized.sh
```

O projeto está disponível em http://localhost

Para executar os teste unitários automatizados execute

```
mvn test
```

Para executar os teste de integração automatizados execute rode projeto com algum dos comandos mencionados anteriormente anteriores 

```
mvn -Dtest=com.carlos.weblanches.CucumberJava test
```

Antes de rodar os testes unitários altere arquivo: `src/test/resources/cucumber.properties`

Altera a variável `url` para o servidor onde está deployada a aplicação junto com a porta e 
altere a variável `driverAddress` para o caminho do driver do chrome
