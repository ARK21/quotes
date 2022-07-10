package ru.ark.quotes.api.controllers.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountControllers {

    @GetMapping("/hello")
    public String sayHello() {
      return "Hello";
    };
}
