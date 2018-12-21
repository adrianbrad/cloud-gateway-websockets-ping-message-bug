Related to this issue [spring-cloud-gateway#729](https://github.com/spring-cloud/spring-cloud-gateway/issues/729) 

Currently using the 2.1.0 version of Spring Cloud Gateway if a Websocket connection is made through the gateway the Ping messages sent by the server are not received on the client

### Running

#### Gateway

```
cd cloud-gateway
mvn clean install -DskipTests=true
java -jar target/cloud-gateway-0.0.1-SNAPSHOT.jar
```

#### WebSocket Server


```
cd websockets-server
mvn clean install -DskipTests=true
java -jar target/websockets-server-0.0.1-SNAPSHOT.jar
```

#### WebSocket Client

```
cd ws-client
node ws-client.js //for connecting directly to the sever
node ws-client.js gateway //for connection to the server through gateway
```

### Behavior example

#### Direct connection
```
$ node ws-client.js
cconnection to ws://localhost:8090/
11:40:35
Connection opened on: 127.0.0.1:8090
11:40:40
ping received
11:40:45
ping received
11:40:50
ping received
11:40:55
ping received
11:41:0
ping received
```

#### Gateway connection

```
$ node ws-client.js gateway
connection to ws://localhost:8080/
11:40:38
Connection opened on: 127.0.0.1:8080
```
