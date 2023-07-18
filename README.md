This repository contains example of SOAP service and client with spring boot 2 and java 11.

## Steps to run
* Built the project using `mvn clean install`.
* Run soap-server module first which by default runs at 8081 port.
* Run soap-client module then which by default runs at 8080 port.
* Hit HTTP endpoint : `http://localhost:8080/test-soap/country` which internally uses soap client to call the soap service running at `http://localhost:8081/mySoapService`.