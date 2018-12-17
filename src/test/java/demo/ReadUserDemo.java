package demo;

import org.faezCode.npft.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadUserDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();


        //create session
        Session session = factory.getCurrentSession();

        try {
            //create a student object
            System.out.println("Creating new student object...");
            User user = new User();
            user.setIdentityNo("1010-1111");
            user.setUserName("Farah");
            user.setPassword("fara123");
            user.setPhoneNo("013-0030");
            user.setEmail("Farah.Fauzi@canang.com.my");
            //start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the user....");
            session.save(user);

            //commit transaction
            session.getTransaction().commit();

            // NEW CODE

            // find out the student's id: primary key
            System.out.println("Saved user. Generated id: " + user.getUserId());

            // get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + user.getUserId());

            User user1 = session.get(User.class, user.getUserId());

            System.out.println("Get complete: "+user1);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

    }
}
