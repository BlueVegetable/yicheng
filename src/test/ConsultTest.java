import cn.studio.zps.blue.ljy.dao.ConsultDao;
import cn.studio.zps.blue.ljy.service.ConsultService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ConsultTest {

    @Autowired
    private ConsultDao consultDao;

    @Autowired
    private ConsultService consultService;

    @Test
    public void test1() {
        List<Short> parameters = new ArrayList<>();
        parameters.add((short)0);
        parameters.add((short)1);
        parameters.add((short)2);
        parameters.add((short)3);
        parameters.add((short)4);
        parameters.add((short)5);
        System.out.println(consultService.countByState(parameters));
    }

    @Test
    public void test2() {
        System.out.println();
    }

    @Test
    public void test3() {
        System.out.println(consultDao.getLimitNumberClassfy(5));
    }

}
