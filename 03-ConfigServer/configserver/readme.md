- Precisa do @EnableConfigServer no ConfigserverApplication e das configurações no application.yml



#### Como visualizar as configurações disponíveis?
Lembre-se desta sintaxe:

* /{application}/{profile}[/{label}]
* /{application}-{profile}.yml
* /{label}/{application}-{profile}.yml
* /{application}-{profile}.properties
* /{label}/{application}-{profile}.properties

Lembre-se que:
   * application é o nome dado no properties que idealmente identifica a aplicação
   * label é a branch
   * profile é o profile do spring

Mostra a configuração da aplicação configclient no profile dev na branch  master
/{application}/{profile}[/{label}]
http://localhost:8888/configclient/dev/master

Mostra  as configurações da aplicação configclient do profile prod no formato yaml, oque tem  na master
/{application}-{profile}.yml
http://localhost:8888/configclient-prod.yml

Mostra as configurações da aplicação configclient do profile prod no formato properties, oque tem na master
/{label}/{application}-{profile}.properties
http://localhost:8888/master/configclient-prod.properties

Mostra a configuração dabranch dev, para o arquivo configclient-dev.properties
/{label}/{application}-{profile}.properties
http://localhost:8888/dev/configclient-dev.properties

Mostra qual será o arquivo padrão, application.properties
http://localhost:8888/master/configclient


Como fazer o servidor um arquivo de uma branch? 


```
mvn clean spring-boot:run -Dspring.profiles.active=dev
mvn clean spring-boot:run -Dspring.profiles=dev,outro
```


Leia mais no [http://medium.com/codigorefinado](https://medium.com/codigorefinado/3-padr%C3%B5es-em-microservi%C3%A7os-servidor-de-configura%C3%A7%C3%A3o-2f89902d0314)