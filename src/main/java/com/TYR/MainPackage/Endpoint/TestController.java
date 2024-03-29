package com.TYR.MainPackage.Endpoint;

import com.TYR.MainPackage.Strings.EndpointPath;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
//@RequestMapping(EndpointPath.TEST_ENDPOINT)
public class TestController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String Hello(){
        return "GET Hello World !";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String postHello(){
        return "POST Hello World !";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.PUT)
    public String putHello(){
        return "PUT Hello World !";
    }

    @PostMapping("/req-body")
    public String reqBody(@RequestBody String value){
        return "Request Body: " + value;
    }
    @PostMapping("/req-body2")
    public String reqBody2(@RequestBody HashMap<String, String> value){
        return "Request Body: " + value;
    }

    @PatchMapping("/req-body3/{value}")
    public String pathVariable(@PathVariable String value){
        return "Value from path Variable : " + value;
    }
}