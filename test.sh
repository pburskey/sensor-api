curl -d '{"start":"2018-04-22_17:03:33", "stop":"2018-04-22_17:03:33","items":[ {"timeStamp":"2018-04-22_17:03:33","measurement":"12.56"}]    }' -H "Content-Type: application/json" -X POST http://localhost:8080/sensor



curl -v -X GET -H"Accept: application/json" http://localhost:8080/sensor/events/last?limit=5