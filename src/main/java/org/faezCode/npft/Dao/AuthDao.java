package org.faezCode.npft.Dao;

import org.faezCode.npft.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("authDao")
public class AuthDao {

    @Autowired(required = true)
    protected SessionFactory sessionFactory;

    @Transactional
    public Boolean findUser(String uname, String pswd){

        Boolean isValid=false;

        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("select u from User u where u.userName=:uname and u.password=:pswd ").setParameter("uname", uname).setParameter("pswd", pswd).getResultList();
        if (users != null && users.size()>0) {
            isValid = true;
        }
        return isValid;
    }
}
