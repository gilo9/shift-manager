package mwa.giles.shiftmanager.controller;

import mwa.giles.shiftmanager.model.Shift;
import mwa.giles.shiftmanager.service.ShiftService;
import mwa.giles.shiftmanager.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@Controller
public class ShiftManagerController {

    private final ShiftService shiftService;
    private final UserService userService;

    public ShiftManagerController(ShiftService shiftService, UserService userService) {
        this.shiftService = shiftService;
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Principal principal ,Model model) {
        model.addAttribute("username", principal.getName());

        //List<Shift> shifts= shiftService.getAllShifts(userService.findEmployeeIdByEmail(username));
        //model.addAttribute("shifts",shifts);
            return "dashboard";
    }
}
