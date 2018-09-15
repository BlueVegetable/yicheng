import cn.studio.zps.blue.ljy.dao.ConsultDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ConsultTest {

    @Autowired
    private ConsultDao consultDao;
    @Test
    public void test1() {
        System.out.println(consultDao.addConsult(consultDao.getConsultById(12)));
    }

    @Test
    public void test2() {
        System.out.println();
    }

}
