package org.faezCode.npft.Controllers;

import org.faezCode.npft.Entity.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(Model model){

        model.addAttribute("login", new Login());
        return "login-form";
    }


    public String loginProcess(@ModelAttribute("login") Login login){


        return "welcome";
    }

}
