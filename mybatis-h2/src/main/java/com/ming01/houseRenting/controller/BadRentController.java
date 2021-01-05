package com.ming01.houseRenting.controller;


import com.ming01.houseRenting.mapper.BadRentMapper;
import com.ming01.houseRenting.model.BadRent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class BadRentController {

    @Autowired
    private BadRentMapper badRentMapper;

    /*
    curl --location --request POST 'http://localhost:8080/addBadRent' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "address": "addressaddressaddress",
        "rentPrice": 9000,
        "message": "messagemessagemessagemessage",
        "longitude": 0.00234,
        "latitude": 0.003456
    }'
     */
    @PostMapping("/addBadRent")
    @ResponseBody
    public String addBadRent(@RequestBody BadRent badRent) {
        int result = badRentMapper.insertBadRent(badRent);
        System.out.println(result);
        return result+"";
    }

}
