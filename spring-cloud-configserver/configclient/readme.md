

Para forçar a atualização dos parâmetros, com o actuator (org.springframework.boot:spring-boot-starter-actuator)
na aplicação envie um post para http://localhost:8090/actuator/refresh

> $ curl localhost:8080/actuator/refresh -d {} -H "Content-Type: application/json"

No spring boot 2 a maioria dos endpoints do actuator vem desativas por padrão, para habilitar inclua no application.properties:
> management.endpoints.web.exposure.include=*