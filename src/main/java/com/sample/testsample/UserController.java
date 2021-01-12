package com.sample.testsample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String index() {
        return "This page is user page";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String add(@RequestParam String name,
                      @DateTimeFormat(pattern = "yyyy-MM-dd")
                      @RequestParam LocalDate birthday) {
        userService.addUser(name, birthday);
        return "Success!!";
    }
}
