package org.faezCode.npft.Dao;

import org.faezCode.npft.Entity.Tests;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class TestsDao {

    @Autowired()
    protected SessionFactory sessionFactory;

    @Transactional
    public Tests findById(int id){
        Session session = sessionFactory.getCurrentSession();
        Tests test=session.get(Tests.class, id);
        return test;
    }
}
