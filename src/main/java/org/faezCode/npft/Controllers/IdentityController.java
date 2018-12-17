package org.faezCode.npft.Controllers;

import org.faezCode.npft.Entity.Participant;
import org.faezCode.npft.Service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IdentityController {

    @Autowired
    ParticipantService participantService;

    @RequestMapping("/")
    public String loginForm(Model model){

        Identity identity = new Identity();

        model.addAttribute("identity", identity);

        return "index";

    }

    @RequestMapping("/processLoginForm")
    public String processForm(@ModelAttribute("identity") Identity identity, Model model){

        //log the data
        System.out.println("identity username: "+ identity.getUsername());
        System.out.println("identity password: "+ identity.getPassword());

        List<Participant> participants = participantService.getParticipant();

        model.addAttribute("participantList", participants);


//        String usrname = identity.getUsername();
//        switch (usrname){
//            case "ADMIN":
//                return "admin-home";
//            case "STAFF":
//                return "staff-home";
//        }

        return "home";
    }
}
