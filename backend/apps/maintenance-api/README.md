## Pasta dedicada aos módulos de backend

Subir container rabbitmq

````bash
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 -p 25672:25672 rabbitmq:3.8-management
````