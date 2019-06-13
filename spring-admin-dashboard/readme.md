### Execute primeiro o projeto eurekaserver

Abra:
> http://localhost:8761
> http://localhost:8761/admin


### Execute o projeto employeeservice

Abra:
> http://localhost:8011/findEmployeeDetails/111

Acompanhe os endereços: 
> http://localhost:8761
> http://localhost:8761/admin


### Execute o projeto api-gateway
Abra:
> http://localhost:8010/employeeDetails/111
> http://localhost:8010/hystrix

Adicione no campo:
> http://localhost:8010/actuator/hystrix.stream

Acompanhe os endereços:


> http://localhost:8761
> http://localhost:8761/admin