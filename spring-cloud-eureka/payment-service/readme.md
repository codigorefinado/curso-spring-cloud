Para executar via linha de comando
> mvnw clean package
> java -jar target/payment-service-0.0.1-SNAPSHOT.jar

> java -jar <path/to/my/jar> --server.port=7788

> mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8085

Quando estiver executando, abra no seu navegador a URK:

(http://localhost:8888/payment/payNow/42)[http://localhost:8888/payment/payNow/42]