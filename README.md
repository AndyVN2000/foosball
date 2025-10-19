# Foosball

## Running the application

```shell
./mvnw clean spring-boot:run
```

## Endpoint calls

Add a player.

```bash
curl -X POST localhost:8080/players -H 'Content-Type:application/json' -d '{"name": "John Doe", "initials": "J.D.", "handicap": 10}'
```

Get all players.

```bash
curl localhost:8080/players
```
