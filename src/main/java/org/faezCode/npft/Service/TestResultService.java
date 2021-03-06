package org.faezCode.npft.Service;

import org.faezCode.npft.Dao.TestResultDao;
import org.faezCode.npft.Entity.TestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("testResultService")
public class TestResultService {

    @Autowired
    private TestResultDao testResultDao;

    public TestResult findById(int id){

        TestResult testResult = testResultDao.findById(id);
        return testResult;

    }

    public int calcTotalMarks(int pid){

        int totalMarks = testResultDao.calcTotalMarks(pid);
        return totalMarks;

    }

    public int getTestScore(int pid, int tid){

        int score = testResultDao.getTestScore(pid, tid);
        return score;

    }

    public List<TestResult> getTestResult(int pid, int tid){

        List<TestResult> testResult = testResultDao.getTestResult(pid, tid);

        return testResult;

    }


    public List<TestResult> findByPId(int pid) {

        List<TestResult> testResult = testResultDao.findByPId(pid);

        return testResult;
    }
}
