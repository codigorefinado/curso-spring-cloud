- [http://localhost:8000/actuator/](http://localhost:8000/actuator/)
- [http://localhost:8000/actuator/health](http://localhost:8000/actuator/health)

Teste
```
curl http://localhost:8000/actuator/loggers
curl http://localhost:8000/actuator/loggers/root
curl http://localhost:8000/actuator/health
curl http://localhost:8000/actuator/metrics/jvm.memory.used
```

[Actuator](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready) é

Oferece por padrão uma série de [endpoints (endereços)](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready-endpoints)
que no permite monitorar e gerenciar a aplicação, que também pode ocorrer por JMX.

Expondo todos os endereços:
```
    management.endpoints.web.exposure.include=*
```

Alternativamente você pode desabilitar todos os endereços, e habilitar apenas oque você deseja individualmente:
```
management.endpoints.enabled-by-default=false
management.endpoint.info.enabled=true
```
Você também pode especificar quais quer expor passando um conjunto de recursos separados por virgula
```
management.endpoints.web.exposure.include= health,info,env
```

Excluindo o recurso `env`
```
    management.endpoints.web.exposure.exclude=env
```

Para desabilitar todo o actuator você pode desligar a porta:
```
management.server.port=-1
```

ou pode deixar de expor todos os endereços: 
```
management.endpoints.web.exposure.exclude=*
```

É possível deixar a aplicação em uma porta, e o actuator em outra.
Para configurar a porta da aplicação:
```
    server.port=8000
```
Se você não configurar a porta do actuator, será utilizado a mesma da aplicação. Para configurar a porta do actuator:
```
    management.server.port=8001
```

Por padrão, a maioria dos endereços do actuator são habilitados, caso deseje habilitar ou desabilitar pode-se utilizar a propriedade `management.endpoint.<id>.enabled`, 
mudando o `<id>` pelo atribudo desejado, por exemplo podemos habilitar que possamos enviar um [POST para desligar o servidor](https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-actuator/src/main/java/org/springframework/boot/actuate/context/ShutdownEndpoint.java): 

```
    management.endpoint.shutdown.enabled=true
```

Teste enviando a requisição como do tipo POST
```
curl -X POST http://localhost:8000/actuator/shutdown
```


Por padrão `/actuator/info` é vazio, isto ocorre porque este é um endereço reservado para você customizar, para isto é necessário criar um ou mais beans.
```
import java.util.HashMap;
import java.util.Map;
 
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
 
@Component
public class BuildInfoContributor implements InfoContributor {
     
    @Override
    public void contribute(Info.Builder builder) {
        Map<String,String> data= new HashMap<String,String>();
        data.put("build.version", "2.0.0");
        builder.withDetail("buildInfo", data);
    }
     
}
```

Também é possivel enrriquecer o `/actuator/info` com  informações da construção da aplicação
```
info.app.name=@project.name@
info.app.description=@project.description@
info.app.version=@project.version@
info.app.encoding=@project.build.sourceEncoding@
info.app.java.version=@java.version@
```

##### management.security.enabled: false
Desde que seu serviço esteja protejido por firewall e não esteja exposta ao publico, talvez você não precise habilitar
Se você não tem o [Spring Security](https://www.callicoder.com/spring-boot-actuator/#securing-actuator-endpoints-with-spring-security) no class path, não precisa desabilitar

```
management:
  security:
    enabled: false
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


Para o caso de querer utilizar JMX, você pode utilizar a configuração abaixo, informano * para expor ou remover tudo, 
ou passar uma lista de recursos separado por virgula
```
management.endpoints.jmx.exposure.include=*
management.endpoints.jmx.exposure.exclude=
```

Leia sobre [Padrões de observabilidade](https://medium.com/codigorefinado/padr%C3%B5es-de-microservi%C3%A7os-observabilidade-2be3141746de)
Leia sobre [Padrões de disponibilidade](https://medium.com/codigorefinado/padr%C3%B5es-de-microservi%C3%A7os-disponibilidade-f457ac6f9bea)

