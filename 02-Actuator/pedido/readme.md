### Como executar?
Na ide, execute o arquivo que contem o método main, no caso o PedidoApplication

Via linha de comando:
> mvnw clean package
> java -jar target/TEU_JAR.jar

> java -jar CAMINHO/DO/TEU/JAR --server.port=7788

> mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8085

#### [Actuator](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)

[Observabilidade](https://medium.com/codigorefinado/padr%C3%B5es-de-microservi%C3%A7os-observabilidade-2be3141746de)

- http://localhost:8000/actuator/
- http://localhost:8000/actuator/health


##### management.security.enabled: false
Desde que seu serviço esteja protegido por firewall e não esteja exposta ao público, talvez você não precise habilitar.
Se você não tem o Spring Security no class path, não precisa desabilitar

```
management:
  security:
    enabled: false
```

##### *(Asterisco) [Expoe](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html#production-ready-endpoints-exposing-endpoints) todos os recursos para serem acessados via HTTP
     
```
management:
  endpoints:
    web:
      exposure:
        include: *
```

##### * [Exclui](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html#production-ready-endpoints-exposing-endpoints) todos os recursos (exceto env e beans) para serem acessados via HTTP
```
management:
  endpoints:
    web:
      exposure:
        exclude: env, beans
```

##### Habilita CORS

```
management:
  endpoints:
    web:
      cors:
        allowed-origins: https://example.com
        allowed-methods: GET, POST
```

