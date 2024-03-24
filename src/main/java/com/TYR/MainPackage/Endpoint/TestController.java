package com.TYR.MainPackage.Endpoint;

import com.TYR.MainPackage.Strings.EndpointPath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndpointPath.TEST_ENDPOINT)
public class TestController {
    @GetMapping
    public String testHello(){
        return "Get Hello";
    }
}
