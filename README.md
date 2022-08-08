# spring-javaagent-test

a test project for getting spring's request information by javaagent

- build

```
cd agent ; gradle shadowJar
cd spring ; gradle bootJar
```

- run server

```
java -javaagent:<PATH>/agent/build/libs/java-agent-1.0-SNAPSHOT-all.jar=agentarg -jar <PATH>/spring/build/libs/demo-0.0.1-SNAPSHOT.jar
```

- http request

```
curl http://localhost:8080/
```
