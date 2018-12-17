package org.faezCode.npft.Service;

import org.faezCode.npft.Dao.TestsDao;
import org.faezCode.npft.Entity.Tests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service("testsService")
public class TestsService {

    @Autowired
    private TestsDao testsDao;

    public Tests findById(int id){
        Tests tests = testsDao.findById(id);
        return tests;
    }
}
