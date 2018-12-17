package demo;

import org.faezCode.npft.Entity.Participant;
import org.faezCode.test.TestApplicationConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestApplicationConfig.class)
public class CreateUserTest {

    @Autowired
    private SessionFactory factory;

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
            participant1.setHeight(175);
            participant1.setWeight(60);
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

}
