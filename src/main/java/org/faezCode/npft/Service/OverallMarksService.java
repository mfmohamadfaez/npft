package org.faezCode.npft.Service;

import org.faezCode.npft.Dao.OverallMarkDao;
import org.faezCode.npft.Entity.OverallMarks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service("overallMarksService")
public class OverallMarksService {

    @Autowired
    private OverallMarkDao overallMarkDao;

    public OverallMarks findById(int id) {
        OverallMarks overallMark = overallMarkDao.findById(id);
        return overallMark;
    }

    public OverallMarks findByPId(int pid) {
        OverallMarks overallMark = overallMarkDao.findByPId(pid);
        return overallMark;
    }

    public int getTotalMark(int pid) {
        int totalMark = overallMarkDao.getTotalMark(pid);
        return totalMark;
    }
}
