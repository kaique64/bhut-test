# Bhut API

## Tecnologias utilzadas

- Java (17)
- Spring Boot
- MongoDB
- Swagger
- Maven
- Docker

## Requisitos para aplicação

- Java (17)
- MongoDB
- RabbitMQ
- Maven

## Como rodar localmente a API

- Primeiro, verifique se tem instalado o MongoDB e veja a porta que está rodando, vá no arquivo de application.properties e insira o seguinte código
```shell
spring.data.mongodb.host=localhost
spring.data.mongodb.port={SUA_PORTA_DO_BANCO_DE_DADOS}
spring.data.mongodb.database=bhut_db
```

- Depois disso, verifique se tem instalado o RabbitMQ e veja a porta que está rodando. Acesse o arquivo application.properties e insira o seguinte código
```shell
spring.rabbitmq.host=localhost
spring.rabbitmq.port={SUA_PORTA_DO_RABBITMQ}
spring.rabbitmq.username={SEU_USUARIO_RABBITMQ}
spring.rabbitmq.password={SUA_SENHA_RABBITMQ}
```

- Caso não tenha o MongoDB nem o RabbitMQ, você pode utilzar o Docker para rodar um container com a imagem do MongoDB e do RabbitMQ, para isso use o seguinte comando
```shell
docker-compose up -d
```

- Agora, basta rodar o seguinte comando para inicializar a aplicação
```shell
mvn spring-boot:run
```

- Servidor irá rodar em http://localhost:8080, caso tenha a necessidade de troca da porta adicione a seguinte propriedade no arquivo application.prpperties
```shell
server.port={SUA_PORTA_DO_SERVIDOR}
```

## Documentação
Para acessar a documentação basta acessar http://localhost:8080/swagger-ui.html