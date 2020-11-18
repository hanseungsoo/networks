package io.human.networks.controller;

import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/Hello")
    public ResponseEntity hello() {
        return new ResponseEntity("hello", HttpStatus.OK);
    }
}
