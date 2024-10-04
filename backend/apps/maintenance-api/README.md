## Requisitos

- Java 17
- Docker

Subir container docker do mysql

````bash
docker run -d --name mysql -e MYSQL_ROOT_PASSWORD=toor -e MYSQL_USER=root -p 3306:3306 mysql:8.0.20 
````

Subir container rabbitmq

````bash
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 -p 25672:25672 rabbitmq:3.8-management
````

Subindo via docker compose

````bash
docker compose up -d --build
````

Ambas as aplicações possuem um docker compose para serem executadas individualmente. Para subir todo o APP, é preciso subir o docker compose da pasta raiz do projeto

## Firebase

É necessário adicionar aos resources do projeto a chave de service-account no formato `.json`.
A chave fica omitida em função de uma entrada no arquivo .gitignore, uma vez que é uma chave privada.

Para isso é preciso ter uma conta no firebase com o módulo de autenticação por email e senha configurado.
Basta criar uma chave em `Project Settings` > `Service accounts` selecionado o SDK do Java.

Logo, também é preciso de pelo menos um usuário cadastrado para efetuar o login.

## Teste local da API

Para testar a aplicação é necessário ter um token JWT válido cadastrado no mesmo domínio de aplicação do service-account configurado no passo anterior.

Recuperando um token (substituir os valores entre chaves)
````bash
 curl --location --request POST 'https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key={apikey}' \
--header 'content-type: application/json' \
--data-raw '{
    "email": "{user.email}",
    "password": "{user.password}",
    "returnSecureToken": true
}'
````

Agora basta passar esse token nas requisições no header 'Authorization: Bearer {token}'

## Healthcheck

A API possui um endpoint de healthcheck para testar a saúde da mesma. Esse endpoint não possui autenticação, uma vez que sua finalidade é validar que a aplicação está de pé (simulando um ambiente de orquestração de containers, onde a master do cluster faz o healthcheck dos workers/pods)

````bash
curl --location 'http://localhost:8080/manufacture-api/healthcheck'
````
