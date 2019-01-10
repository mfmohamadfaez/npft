package org.faezCode.npft.Controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.faezCode.npft.Entity.OverallMarks;
import org.faezCode.npft.Entity.Participant;
import org.faezCode.npft.Entity.TestResult;
import org.faezCode.npft.Service.OverallMarksService;
import org.faezCode.npft.Service.ParticipantService;
import org.faezCode.npft.Service.TestResultService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class ParticipantController {

    protected static List<TestResult> testResults = new ArrayList<TestResult>();

    @Autowired
    ParticipantService participantService;

    @Autowired
    TestResultService testResultService;

    @Autowired
    OverallMarksService overallMarksService;

    @Autowired
    DataSource dataSource;

    private Gson gson = new GsonBuilder().serializeNulls().create();

    @RequestMapping("/participantForm")
    public String showForm(Model model){

        model.addAttribute("participant", new Participant());

        return "participant-form";

    }

    @RequestMapping("/processParticipantForm")
    public String submitForm(@Valid @ModelAttribute("participant") Participant participant, BindingResult theBindingResult, Model model){

        System.out.println("Binding Result: " + theBindingResult);

        if (theBindingResult.hasErrors()) {
            return "participant-form";
        }
        else {
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
    }

    @RequestMapping(value = {"/getParticipantById/{pid}"}, method = RequestMethod.GET)
    public @ResponseBody
    String getParticipantById(@PathVariable("pid") int pid, Model model) {

        ArrayList jsonArray = new ArrayList();
        Participant participant = participantService.findById(pid);
        List<TestResult> testResult = testResultService.findByPId(pid);

        model.addAttribute("participantName", participant.getName());
        model.addAttribute("participantNric", participant.getNricNo());
        model.addAttribute("participantAge", participant.getAge());
        model.addAttribute("participantGender", participant.getGender());
        model.addAttribute("participantHeight", participant.getHeight());
        model.addAttribute("participantWeight", participant.getWeight());
        model.addAttribute("participantBodyNo", participant.getBodyNo());
        model.addAttribute("participantTurnNo", participant.getTurnNo());

        jsonArray.add(participant);
        jsonArray.add(testResult);

        return gson.toJson(jsonArray);
    }

    @RequestMapping(value = {"/printParticipant"}, method = RequestMethod.GET)
    @ResponseBody
    public void printParticipant(HttpServletResponse response) throws JRException, IOException, SQLException {
        InputStream jasperStream = this.getClass().getResourceAsStream("/report/participant_details.jrxml");
//        Map<String,Object> params = new HashMap<>();
//        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperReport jasperReport
                = JasperCompileManager.compileReport(jasperStream);
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JREmptyDataSource());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource.getConnection());

        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=NPFTReport.pdf");

        final OutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
    }

    @RequestMapping(value = {"/getParticipantDetails/{pid}"}, method = RequestMethod.GET)
    public String getParticipantDetails(@PathVariable("pid") int pid, Model model) {

        ArrayList jsonArray = new ArrayList();
        Participant participant = participantService.findById(pid);
        List<TestResult> testResult = testResultService.findByPId(pid);
        OverallMarks overallMarks = overallMarksService.findByPId(pid);

        List<TestResult> testResult1 = testResultService.getTestResult(pid, 1);
        List<TestResult> testResult2 = testResultService.getTestResult(pid, 2);
        List<TestResult> testResult3 = testResultService.getTestResult(pid, 3);
        List<TestResult> testResult4 = testResultService.getTestResult(pid, 4);
        List<TestResult> testResult5 = testResultService.getTestResult(pid, 5);


        model.addAttribute("participantName", participant.getName());
        model.addAttribute("participantNric", participant.getNricNo());
        model.addAttribute("participantAge", participant.getAge());
        model.addAttribute("participantGender", participant.getGender());
        model.addAttribute("participantHeight", participant.getHeight());
        model.addAttribute("participantWeight", participant.getWeight());
        model.addAttribute("participantBodyNo", participant.getBodyNo());
        model.addAttribute("participantTurnNo", participant.getTurnNo());


        model.addAttribute("testResultBmi", testResult1.get(0));
        model.addAttribute("testResultGenggaman", testResult2.get(0));
        model.addAttribute("testResultDudukJ", testResult3.get(0));
        model.addAttribute("testResultBangunT", testResult4.get(0));
        model.addAttribute("testResultBleepT", testResult5.get(0));
        model.addAttribute("totalMark", overallMarks.getTotalMark());
        model.addAttribute("awardType", overallMarks.getAwardType());

        return "viewParticipantDetails";
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
        participant.setWeight(60.0);
        participant.setHeight(175.0);
        participant.setBodyNo(0005);

        model.addAttribute("participant", participant);
        model.addAttribute("testResult", new TestResult());

        return "test-result-form";
    }

}
