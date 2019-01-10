package demo;

import org.faezCode.npft.Entity.Participant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateUserDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Participant.class)
                .buildSessionFactory();


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
            //start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the student....");
            session.save(participant1);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

    }
}
