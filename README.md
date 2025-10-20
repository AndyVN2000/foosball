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

End a foosball match (which is supposed to increment handicap of winners and decrement handicap of losers).

Note: not completely sure how to write a proper request method that serves the purpose of "changing the state"
of an entity. `PUT` seemed like the most suitable type. But what about my path? Does that make any sense in  
a RESTful way?

```bash
curl -X PUT "localhost:8080/matches/0"
```

## Issues

I seem to be unable to make a match end properly and as result change the handicaps for the winners and losers. The call on `endMatch()` in the Domain works. But the state of the participating players
does not change...
Do I need to implement my own implementation of `MatchRepository` instead of Spring generating a Proxy?
