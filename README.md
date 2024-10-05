# SmartMES Core

## Requisitos

- Docker
- Firebase Authentication

### TODO - adicionar requisitos/dependências do front ao readme.md && ao docker compose

## Como subir as aplicações

Adicionar a chave service-account.json do firebase à pasta `/resources` de cada projeto projeto

- backend/apps/manufacturing-api/src/main/resources
- backend/apps/maintenance-api/src/main/resources

Agora basta rodar o comando abaixo para subir toda a stack

````bash
docker compose up -d
````

Caso seja feita alguma alteração nas aplicações, deve-se rodar com a flag `--build`
````bash
docker compose up -d --build --force-recreate
````

Antes de testar a aplicação, é necessário importar as rotas do gateway fazendo o download do arquivo ``kong-gateway-routes.json``

### Etapas

1 - Acessar o endereço ``http://localhost:1337`` que é o admin do kong (Konga)

2 - É necessário configurar a conexão cadastrando usuário e senha

3 - Acessar a aba ``snapshots`` e clicar em `Import from file`

4 - Selecione o arquivo ``kong-gateway-routes.json`` que está na raiz do projeto e clique em ok

## Para testar a saúde das aplicações (não necessita autenticação)

Manufacture API
````bash
curl http://localhost:8000/manufacture-api/healthcheck
````

Maintenance API
````bash
curl http://localhost:8000/maintenance-api/healthcheck
````
A porta 8000 é do serviço do kong, ou seja, todas as requisições para as APIs passam pelo gateway
