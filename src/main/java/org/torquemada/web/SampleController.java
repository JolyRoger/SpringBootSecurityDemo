package org.torquemada.web;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    String root() {
        return "home";
    }

    @RequestMapping("/home")
    String home() {
        return "home";
    }

    @RequestMapping("/hello")
    String hello() {
        return "hello";
    }

    @RequestMapping("/login")
    String login() {
        return "login";
    }
}
