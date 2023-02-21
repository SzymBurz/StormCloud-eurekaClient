package com.wtd.client.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public interface GreetingController {
    @RequestMapping("/greeting")
    String greeting();

    @RequestMapping(value = "whoami/{username}")
    String whoami(@PathVariable String username);

}