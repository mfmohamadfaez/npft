package org.faezCode.npft.Dao;

import org.faezCode.npft.Entity.OverallMarks;
import org.faezCode.npft.Entity.Participant;
import org.faezCode.npft.Entity.TestResult;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository("participantDao")
public class ParticipantDao {

    @Autowired(required = true)
    protected SessionFactory sessionFactory;

    public List<Participant> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Participant> cq = cb.createQuery(Participant.class);
        Root<Participant> root = cq.from(Participant.class);
        cq.select(root);
        Query<Participant> query = session.createQuery(cq);
        return query.getResultList();
    }

    public List<Participant> getParticipant() {
        Session session = sessionFactory.getCurrentSession();
        List<Participant> participants = session.createQuery("from Participant").getResultList();
        return participants;
    }

    @Transactional
    public Participant findById(int id) {

        Session session = sessionFactory.getCurrentSession();
        Participant participant = session.get(Participant.class, id);
        return participant;

    }

    public void deleteParticipant(int id) {
        Session session = sessionFactory.getCurrentSession();

        List<TestResult> testResult = session.createQuery("from TestResult tr where tr.pId.id= :pid ").setParameter("pid", id).getResultList();

        OverallMarks overallMark = (OverallMarks) session.createQuery("select om from OverallMarks om where om.pId.id=:pid ").setParameter("pid", id).uniqueResult();

        Participant participant = session.find(Participant.class, id);

        for (TestResult result: testResult) {
            session.remove(result);
        }

        session.remove(overallMark);
        session.remove(participant);
        session.flush();
        session.clear();

    }
}
