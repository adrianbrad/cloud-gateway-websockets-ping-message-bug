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