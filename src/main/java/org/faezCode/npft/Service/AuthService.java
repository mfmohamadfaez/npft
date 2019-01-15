package org.faezCode.npft.Service;

import org.faezCode.npft.Dao.AuthDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service("authService")
public class AuthService {

    @Autowired
    private AuthDao authDao;

    public Boolean findUser(String uname, String pswd){

        Boolean isValid = authDao.findUser(uname, pswd);

        return isValid;
    }

}
