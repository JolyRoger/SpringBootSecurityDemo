package org.torquemada.web;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static java.util.stream.Collectors.joining;

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
    String hello(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();

        model.addAttribute("username", user.getUsername());
        model.addAttribute("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(joining(", ")));
        return "hello";
    }

    @RequestMapping("/login")
    String login() {
        return "login";
    }
}
