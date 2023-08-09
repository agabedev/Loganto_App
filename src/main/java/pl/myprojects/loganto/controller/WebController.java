package pl.myprojects.loganto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WebController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
    @GetMapping("/owner")
    public String owner(Model model) {
        return "owner";
    }
//    @GetMapping("/login")
//    public String login() {
//        return "custom-login";
//    }
}
