package com.loja.produto.component;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  curl http://localhost:8000/actuator/loggers/{name}
 *
 *  curl http://localhost:8000/actuator/loggers/root
 *
 *  curl localhost:8000/actuator/health
 *
 *  curl http://localhost:8000/actuator/dbconnectionstatus/
 *
 *  curl -H "Content-Type: application/json" -d '{"isConnected": "true"}' http://localhost:8000/actuator/dbconnectionstatus/dynamodb
 *
 *  curl http://localhost:8000/actuator/dbconnectionstatus/dynamodb
 */
@Endpoint(id = "dbconnectionstatus", enableByDefault = true) //Value must not start with an uppercase letter
@Component
public class DBConnectionStatusEndpoint {

    private final Map<String, Boolean> names = new HashMap<>();

    DBConnectionStatusEndpoint() {
        this.names.put("oracle", Boolean.TRUE);
        this.names.put("postgresql", Boolean.FALSE);
        this.names.put("dynamodb", Boolean.FALSE);
    }

    @ReadOperation
    public List<Boolean> getAllDbConnectionStatus() {
        return new ArrayList<>(this.names.values());
    }

    @ReadOperation
    public Boolean getDBConnectionStatus(@Selector String dbname) {
        return this.names.get(dbname);
    }

    @WriteOperation
    public void updateDbConnectionStatus(@Selector String dbname, Boolean isConnected) {
        this.names.put(dbname, isConnected);
    }
}