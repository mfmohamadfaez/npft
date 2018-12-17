package demo;

import org.faezCode.npft.Entity.Participant;
import org.faezCode.npft.Entity.TestResult;
import org.faezCode.npft.Entity.Tests;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryUserDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(TestResult.class)
                .addAnnotatedClass(Participant.class)
                .addAnnotatedClass(Tests.class)
                .buildSessionFactory();


        //create session
        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();

            int id=5;

            //query students
            List<TestResult> testResults = session.createQuery("from TestResult tr where tr.pId.id=:id and tr.testId.id=:id").setParameter("id", id).getResultList();
            System.out.println();

            //display the students
            displayStudents(testResults);

            /*//query students: userName='Paulo'
            tests = session.createQuery("from User s where s.userName='Paulo'").getResultList();

            //display the students
            System.out.println("\n\nUser who have name of Paulo");
            displayStudents(users);*/


            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

    }

    private static void displayStudents(List<TestResult> testResults) {
        for (TestResult testResult : testResults ) {
            System.out.println(testResult);
        }
    }
}
