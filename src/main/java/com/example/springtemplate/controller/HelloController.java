package com.example.springtemplate.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {

        LOG.info("API Called");

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("myheader", "myheader");
        return ResponseEntity
                .status(200)
                .headers(responseHeaders)
                .body("hello");
    }

}
