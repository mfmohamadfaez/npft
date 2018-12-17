package org.faezCode.npft.Controllers;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

//    @RequestMapping("/")
    public String viewHome(){

        return "home";

    }

}
