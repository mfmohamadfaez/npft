package org.faezCode.npft.Controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.faezCode.npft.Entity.OverallMarks;
import org.faezCode.npft.Entity.Participant;
import org.faezCode.npft.Entity.User;
import org.faezCode.npft.Service.AuthService;
import org.faezCode.npft.Service.OverallMarksService;
import org.faezCode.npft.Service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class IdentityController {

    @Autowired
    ParticipantService participantService;

    @Autowired
    OverallMarksService overallMarksService;

    @Autowired
    AuthService authService;
    @Autowired
    MessageSource messageSource;
    private Gson gson = new GsonBuilder().serializeNulls().create();

    @RequestMapping("/")
    public String loginForm(Model model) {

        Identity identity = new Identity();

        model.addAttribute("identity", new User());

        return "index";

    }

    @RequestMapping("/processLoginForm")
    public String processForm(@ModelAttribute("identity") User user, Model model) {

        //log the data
        System.out.println("identity username: " + user.getUserName());
        System.out.println("identity password: " + user.getPassword());

        Boolean isValid = authService.findUser(user.getUserName(), user.getPassword());
        String errorMsg = "";
        if (isValid) {
            List<Participant> participants = participantService.getParticipant();
            List<OverallMarks> overallMarks = new ArrayList<>();

            model.addAttribute("participantList", participants);
            return "home";
        }

        errorMsg = "Invalid username and/or password";

        model.addAttribute("errorMsg", errorMsg);

        return "index";
    }

    @RequestMapping("/getParticipantDataTable")
    public @ResponseBody
    String getParticipantDataTable() {

        Map<String, List> jsonMap = new HashMap<String, List>();
        List<List> jsonList = new ArrayList<List>();
        List<String> innerList = null;
        List<String> actionList = null;
        List<Participant> participants = participantService.getParticipant();

        int c = 0;

        for (Participant participant : participants) {
            c++;
            innerList = new ArrayList<String>();
            actionList = new ArrayList<String>();
            innerList.add(String.valueOf(c));
            innerList.add(participant.getName());
            innerList.add(participant.getNricNo());
            innerList.add(overallMarksService.findByPId(participant.getId()).getAwardType());
            innerList.add(getMessage("url.view", new Object[]{"../NPFT/getParticipantDetails/" + participant.getId()}) +
                    getMessage("url.edit", new Object[]{"../NPFT/editParticipantDetails/" + participant.getId()}) +
                    getMessage("url.delete", new Object[]{participant.getId()}));
//            innerList.add("<a href='#' class='buttonRoundSmall' onclick='window.open(''getParticipantDetails/"+participant.getId()+"', ''regWindow'', toolbar=''no'', status=''no'', menubar=''no'', scrollbars=''yes'')'>View</a>");

            jsonList.add(innerList);
        }

        System.out.println("INSIDE TABLE GENERATOR");

        jsonMap.put("aaData", jsonList);
        String result = gson.toJson(jsonMap);
        return result;

    }

    public String getMessage(String code, Object[] params) {
        return messageSource.getMessage(code, params, code, Locale.ENGLISH);
    }
}
