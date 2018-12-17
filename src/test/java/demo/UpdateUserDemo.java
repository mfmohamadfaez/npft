package demo;

import org.faezCode.npft.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateUserDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();


        //create session
        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();

            int studentId = 1;

            User user = session.get(User.class, studentId);
            user.setUserName("Paulo");

            //commit transaction
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            //update email for all students
            session.createQuery("update User set email='abc@def.com'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

    }
}
