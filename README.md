# SmartMES Core

## Requisitos

- docker
- Firebase Authentication

## TODO - adicionar requisitos/dependências do front ao readme.md E ao docker compose
## TODO - adicionar kong gateway ao compose e adaptar as rotas para o front-end

## Como subir as aplicações

````bash
docker compose up -d
````

Caso a(s) aplicação(ões) não suba(m) corretamente ou aconteça alguma falha na conexão com o banco de dados, execute com a flag `--force-recreate`
````bash
docker compose up -d --force-recreate
````

E caso seja feita alguma alteração na aplicação, deve-se rodar com a flag `--build`
````bash
docker compose up -d --build --force-recreate
````