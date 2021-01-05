## Run
start server
```sh
./mvnw spring-boot:run
```

send POST request
```sh
    curl --location --request POST 'http://localhost:8080/addBadRent' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "address": "addressaddressaddress",
        "rentPrice": 9000,
        "message": "messagemessagemessagemessage",
        "longitude": 0.00234,
        "latitude": 0.003456
    }'
```

test for Mapper, see `com.ming01.houseRenting.mapper.BadRentMapperTest`
