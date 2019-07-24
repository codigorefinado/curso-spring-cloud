#### [Actuator](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)

[Observabilidade](https://medium.com/codigorefinado/padr%C3%B5es-de-microservi%C3%A7os-observabilidade-2be3141746de)

- http://localhost:8000/actuator/
- http://localhost:8000/actuator/health


##### management.security.enabled: false
Desde que seu serviço esteja protejido por firewal e não esteja exposta ao publico, talvez você não precise habilitar
Se você não temo Spring Security no class path, não precisa desabilitar

```
management:
  security:
    enabled: false
```

##### *(Asterisco) [Expoe](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html#production-ready-endpoints-exposing-endpoints) todos os recursos para serem acessaados via HTTP
     
```
management:
  endpoints:
    web:
      exposure:
        include: *
```

##### * [Exclui](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html#production-ready-endpoints-exposing-endpoints) todos os recursos (exceto env e beans) para serem acessaados via HTTP
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

