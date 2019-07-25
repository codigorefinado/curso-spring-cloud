#####
http://localhost:8761/

##### Dependencias
-  Eureka discovery Server
```
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
```

#### application.properties

```
server.port=8761
eureka.client.register-with-eureka=false
```

##### Adicione na classe principal (ServicediscoveryApplicaiton)
```
@EnableEurekaServer
```


