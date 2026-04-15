package mwa.giles.shiftmanager.controller;

import lombok.extern.slf4j.Slf4j;
import mwa.giles.shiftmanager.model.Shift;
import mwa.giles.shiftmanager.model.User;
import mwa.giles.shiftmanager.model.userDTO;
import mwa.giles.shiftmanager.service.ShiftService;
import mwa.giles.shiftmanager.service.UserService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.LoggerFactory;
import java.security.Principal;
import java.util.List;

@Slf4j
@Controller
public class ShiftManagerController {

    private final ShiftService shiftService;
    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(ShiftManagerController.class);
    public ShiftManagerController(ShiftService shiftService, UserService userService) {
        this.shiftService = shiftService;
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value = "register", defaultValue = "false") boolean register, Model model) {
        if (register) {
            model.addAttribute("newUser", new userDTO());
        }
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Principal principal ,Model model) {
        String username = principal.getName();
        model.addAttribute("username", username);

        logger.info("Logged in as:" + username);
try{
        List<Shift> shifts= shiftService.shiftByUser(userService.findEmployeeByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found")));
        model.addAttribute("shifts",shifts);
}
        catch (UsernameNotFoundException e){
            return "redirect:/login";
        }

            return "dashboard";
    }


    @PostMapping("/register")
    public String handleRegister(@ModelAttribute userDTO newUser) {
        System.out.println(newUser.getFirstname() + " " + newUser.getLastname());
        try{
            userService.registerUser(newUser);}
        catch (Exception e){
            logger.error("register error: ", e);
            return  "redirect:/login?register=true?error=true";
        }

        return "redirect:/login?registered=true";
    }
}
