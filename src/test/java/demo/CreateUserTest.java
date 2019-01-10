package demo;

import org.faezCode.npft.Entity.Participant;
import org.faezCode.npft.Entity.TestResult;
import org.faezCode.npft.Service.OverallMarksService;
import org.faezCode.npft.Service.TestResultService;
import org.faezCode.test.TestApplicationConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestApplicationConfig.class)
public class CreateUserTest {

    @Autowired
    private SessionFactory factory;

    @Autowired
    private TestResultService testResultService;

    @Autowired
    private OverallMarksService overallMarksService;

    @Test
    public void testCreateuser() {

        //create session
        Session session = factory.getCurrentSession();

        try {
            //create a student object
            System.out.println("Creating new participant object...");
            Participant participant1 = new Participant();
            participant1.setName("Faez");
            participant1.setAge(21);
            participant1.setBodyNo(101);
            participant1.setGender('M');
//            participant1.setHeight(175);
//            participant1.setWeight(60);
            participant1.setNricNo("970604-05-5051");
            participant1.setTurnNo(101);

            //save the student object
            System.out.println("Saving the student....");
            session.save(participant1);

            System.out.println("Done!");
        } finally {
            factory.close();
        }

    }

    @Test
    public void getTestResult(){

        Session session = factory.getCurrentSession();

        List<TestResult> testResult = testResultService.getTestResult(6, 1);

        TestResult tr = testResult.get(0);
        System.out.println("MARK : "+tr.getMark()+"SCORE : "+tr.getScore());

    }

    @Test
    public void getTotalMark(){

        Session session = factory.getCurrentSession();

        int totalMark = overallMarksService.getTotalMark(6);

        Assert.assertEquals(30, totalMark);
    }



}
