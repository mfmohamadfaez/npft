package org.faezCode.npft.Controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.faezCode.npft.Entity.Participant;
import org.faezCode.npft.Entity.TestResult;
import org.faezCode.npft.Service.ParticipantService;
import org.faezCode.npft.Service.TestResultService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ParticipantController {

    protected static List<TestResult> testResults = new ArrayList<TestResult>();

    @Autowired
    ParticipantService participantService;

    @Autowired
    TestResultService testResultService;

    private Gson gson = new GsonBuilder().serializeNulls().create();

    @RequestMapping("/participantForm")
    public String showForm(Model model){

        model.addAttribute("participant", new Participant());

        return "participant-form";

    }

    @RequestMapping("/processParticipantForm")
    public String submitForm(@ModelAttribute("participant") Participant participant, Model model){

        //log the data
        System.out.println("participant name: "+ participant.getName());
        System.out.println("participant age: "+ participant.getAge());
        System.out.println("participant gender: "+ participant.getGender());
        System.out.println("participant height: "+ participant.getHeight());
        System.out.println("participant weight: "+ participant.getWeight());
        System.out.println("participant nricNo: "+ participant.getNricNo());
        System.out.println("participant bodyNo: "+ participant.getBodyNo());
        System.out.println("participant turnNo: "+ participant.getTurnNo());

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Participant.class)
                .buildSessionFactory();


        //create session
        Session session = factory.getCurrentSession();

        Participant participant1 = new Participant();
        try {
            //create a student object
            System.out.println("Creating new user object...");
            participant1.setName(participant.getName());
            participant1.setAge(participant.getAge());
            participant1.setBodyNo(participant.getBodyNo());
            participant1.setGender(participant.getGender());
            participant1.setHeight(participant.getHeight());
            participant1.setWeight(participant.getWeight());
            participant1.setNricNo(participant.getNricNo());
            participant1.setTurnNo(participant.getTurnNo());
            //start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the participant....");
            session.save(participant1);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

        /*testResults.add(new TestResult(participant1, testDao.findById(1), 0, 0));
        testResults.add(new TestResult(participant1, testDao.findById(2), 0, 0));
        testResults.add(new TestResult(participant1, testDao.findById(3), 0, 0));
        testResults.add(new TestResult(participant1, testDao.findById(4), 0, 0));
        testResults.add(new TestResult(participant1, testDao.findById(5), 0, 0));
        testResults.add(new TestResult(participant1, testDao.findById(6), 0, 0));

        TestResultForm testResultForm = new TestResultForm();
        testResultForm.setTestResults(testResults);*/


        model.addAttribute("participant", participant1);
        model.addAttribute("testResult", new TestResult());

        return "test-result-form";

    }

    @RequestMapping(value = {"/getParticipantById/{pid}"}, method = RequestMethod.GET)
    public @ResponseBody
    String getParticipantById(@PathVariable("pid") int pid) {

        ArrayList jsonArray = new ArrayList();
        Participant participant = participantService.findById(pid);
        List<TestResult> testResult = testResultService.findByPId(pid);

        jsonArray.add(participant);
        jsonArray.add(testResult);

        return gson.toJson(jsonArray);
    }

    /*@RequestMapping("/processTRForm")
    public String processForm(@ModelAttribute("testResultForm") TestResultForm testResultForm){

        System.out.println(testResultForm);
        System.out.println(testResultForm.getTestResults());
        List<TestResult> testResults = testResultForm.getTestResults();

        if(null != testResults && testResults.size() > 0) {
            ParticipantController.testResults = testResults;
            for (TestResult result : testResults) {
                System.out.printf("%s \t %s \n", result.getId(), result.getpId().getId(), result.getTestId().getId(), result.getMark(), result.getScore());
            }
        }

        return "home";
    }*/

    @RequestMapping("/getView")
    public String getView(Model model){

        Participant participant = new Participant();
        participant.setName("Spiderman");
        participant.setAge(21);
        participant.setNricNo("970604-05-5051");
        participant.setGender('M');
        participant.setTurnNo(1997);
        participant.setWeight(60);
        participant.setHeight(175);
        participant.setBodyNo(0005);

        model.addAttribute("participant", participant);
        model.addAttribute("testResult", new TestResult());

        return "test-result-form";
    }

}
