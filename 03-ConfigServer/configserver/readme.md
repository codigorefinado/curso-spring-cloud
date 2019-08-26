Precisa do @EnableConfigServer no ConfigserverApplication e das configurações no application.yml


Como fazer o cliente utilizar um arquivo de uma branch? Lembre-se esta sintaxe:

/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties


Mostra as configurações da aplicação configclient do profile prod no formato properties, oque tem na master
http://localhost:8888/master/configclient-prod.properties

Mostra  as configurações da aplicação configclient do profile prod no formato yaml, oque tem  na master
http://localhost:8888/configclient-prod.yml

Mostra qual será o arquivo que irá padrão, application.properties
http://localhost:8888/master/configclient

Mostra a configuração dabranch dev, para o arquivo configclient-dev.properties
http://localhost:8888/dev/configclient-dev.properties

Mostra a configuração da aplicação configclient no profile dev na branch  master
http://localhost:8888/configclient/dev/master


mvn clean spring-boot:run -Dspring.profiles.active=dev

spring:
  cloud:
    config:
        label: mybranch

spring:
  cloud:
    config:
      server:
        git: 
          uri: https://gitlab.com/somerepo.git
          username: someuser
          password: somepass
          default-label: branchname