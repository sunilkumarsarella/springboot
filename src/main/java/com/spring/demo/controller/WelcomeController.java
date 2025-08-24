package com.spring.demo.controller;

import com.spring.demo.exception.RequestNotFoundException;
import com.spring.demo.utils.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping("/greet")
    public ResponseEntity<CommonResponse> welcome(@RequestParam("reqType") String type) {

        if (!type.equalsIgnoreCase("success")) {
            throw new RequestNotFoundException("Please provide a valid request type.");
        }

        return ResponseEntity
                .ok(new CommonResponse(true, "Welcome to the Spring Boot Application!", null, 200));
    }
}
