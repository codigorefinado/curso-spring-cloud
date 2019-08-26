Precisa do @EnableConfigServer no ConfigserverApplication e das configurações no application.yml


Mostra as configurações da aplicação configclient do profile prod no formato properties, oque tem na master
http://localhost:8888/master/configclient-prod.properties

Mostra  as configurações da aplicação configclient do profile prod no formato yaml, oque tem  na master
http://localhost:8888/configclient-prod.yml

Mostra qual será o arquivo que irá padrão, application.properties
http://localhost:8888/master/configclient

Mostra a configuração dabranch dev, para o arquivo configclient-dev.properties
http://localhost:8888/dev/configclient-dev.properties