# About
This will run spring-ai application with locally installed ollama.
# Prerequisites
* From [Ollama](https://ollama.com) download installer for your OS.
* Follow installation instruction.

# How to run the application
```aiexclude
gradle bootRun
```

# How to test the application
* Sample request
```aiexclude
curl --location 'http://localhost:8080/ask' \
--header 'Content-Type: application/json' \
--data '{
    "question": "Tell me about northern lights"
}'
```

Please be patient. With 32GB RAM, 11th Gen Intel(R) Core(TM) i7-1165G7 @ 2.80GHz   2.80 GHz processor, sometimes it took more than 2 minutes to get answer.