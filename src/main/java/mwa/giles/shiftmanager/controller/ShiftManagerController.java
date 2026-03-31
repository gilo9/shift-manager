package mwa.giles.shiftmanager.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShiftManagerController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public String login(String Email, String Password) {
            return "dashboard";
    }
}
