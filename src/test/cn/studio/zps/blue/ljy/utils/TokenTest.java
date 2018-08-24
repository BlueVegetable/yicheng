package cn.studio.zps.blue.ljy.utils;

import cn.studio.zps.blue.ljy.dao.AdminDao;
import cn.studio.zps.blue.ljy.domain.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TokenTest {

    @Autowired
    private AdminDao adminDao;

    @Test
    public void test1(){
        String jwt=Token.createToken(adminDao.getAdminById(1));
        System.out.println(jwt);
//        System.out.println(Token.parseToken(jwt, Admin.class));
    }

}
