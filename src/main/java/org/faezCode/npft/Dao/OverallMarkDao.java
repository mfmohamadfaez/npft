package org.faezCode.npft.Dao;

import org.faezCode.npft.Entity.OverallMarks;
import org.faezCode.npft.Entity.TestResult;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class OverallMarkDao {

    @Autowired()
    protected SessionFactory sessionFactory;

    @Transactional
    public OverallMarks findById(int id){
        Session session = sessionFactory.getCurrentSession();
        OverallMarks overallMark =session.get(OverallMarks.class, id);
        return overallMark;
    }

    @Transactional
    public OverallMarks findByPId(int pid){
        Session session = sessionFactory.getCurrentSession();
        OverallMarks overallMark = (OverallMarks) session.createQuery("select om from OverallMarks om where om.pId.id=:pid ").setParameter("pid", pid).uniqueResult();

        return overallMark;

    }

    @Transactional
    public int getTotalMark(int pid){

        Session session = sessionFactory.getCurrentSession();
        OverallMarks overallMark = (OverallMarks) session.createQuery("select om from OverallMarks om where om.pId.id=:pid ").setParameter("pid", pid).uniqueResult();

        return overallMark.getTotalMark();
    }

}
