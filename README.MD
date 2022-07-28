# Bhut API Test

## Tecnologias utilzadas

- Java (17)
- Spring Boot
- MongoDB
- Maven

## Requisitos para aplicação

- Java (17)
- MongoDB
- Maven

## Como rodar localmente a API

- Primeiro verifique se tem instalado o MongoDB e veja a porta que está rodando e vá no arquivo de application.properties e insira o seguinte código
```shell
spring.data.mongodb.host=localhost
spring.data.mongodb.port={DB_PORTA}
spring.data.mongodb.database=bhut_db
```
- Caso não tenha o MongoDB, você pode utilzar o Docker para rodar um container com a imagem do MongoDB, para isso use o seguinte comando
```shell
docker run -d -p 27017:27017 mongo
```

- Agora, basta rodar o seguinte comando para inicializar o servidor
```shell
mvn spring-boot:run
```

- Servidor irá rodar em http://localhost:8080, caso tenha a necessidade de troca da porta adicione a seguinte propriedade no arquivo application.prpperties
```shell
server.port={PORTA_DO_SERVIDOR}
```
