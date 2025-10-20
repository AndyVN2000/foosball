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

Find a player by name. (`%20` is URL-encoding for space character).

```bash
curl "localhost:8080/players?name=Foo%20Bar"
```

Delete a player by name.

```bash
curl -X DELETE "localhost:8080/players?name=Foo%20Bar"
```

Change player name.

```bash
curl -X PUT "localhost:8080/players?name=Foo%20Bar&newName=Foo"
```
