Execute a aplicação três vezes, com portas diferentes

> mvnw clean package
> java -jar target/person-0.0.1-SNAPSHOT.jar --server.port=9090
> java -jar target/person-0.0.1-SNAPSHOT.jar --server.port=9091
> java -jar target/person-0.0.1-SNAPSHOT.jar --server.port=9092

Também pode optar por executar desta maneira
> mvnw spring-boot:run -Dspring-boot.run.arguments=--server.port=9093

