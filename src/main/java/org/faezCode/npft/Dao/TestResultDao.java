package org.faezCode.npft.Dao;

import org.faezCode.npft.Entity.TestResult;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class TestResultDao {

    @Autowired()
    protected SessionFactory sessionFactory;

    @Transactional
    public TestResult findById(int id){
        Session session = sessionFactory.getCurrentSession();
        TestResult testResult=session.get(TestResult.class, id);
        return testResult;
    }

    @Transactional
    public int calcTotalMarks(int id){

        Session session = sessionFactory.getCurrentSession();
        List<TestResult> testResults = session.createQuery("select tr from TestResult tr where tr.pId.id=:id ").setParameter("id", id).getResultList();

        int sum=0;
        for (TestResult testResult: testResults) {
            int score = testResult.getScore();
            sum+=score;
        }
        return sum;
    }

    @Transactional
    public int getTestScore(int pid, int tid){

        Session session = sessionFactory.getCurrentSession();
        List<TestResult> testResults = session.createQuery("select tr from TestResult tr where tr.pId.id=:pid and tr.testId.id=:tid ").setParameter("pid", pid).setParameter("tid", tid).getResultList();

        int score=0;
        for (TestResult testResult: testResults) {
            score = testResult.getScore();
        }
        return score;
    }

    @Transactional
    public List<TestResult> findByPId(int pid) {

        Session session = sessionFactory.getCurrentSession();
        List<TestResult> testResult = session.createQuery("from TestResult tr where tr.pId.id= :pid ").setParameter("pid", pid).getResultList();

        return testResult;
    }

}
