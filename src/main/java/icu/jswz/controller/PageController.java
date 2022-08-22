package icu.jswz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/login")
    public String logout() {
        return "login";
    }

    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}
