# Running the application

```shell
./mvnw clean spring-boot:run
```

# Endpoint calls

```bash
curl -X POST localhost:8080/players -H 'Content-Type:application/json' -d '{"name": "John Doe", "initials": "J.D.", "handicap": 10}'
```
