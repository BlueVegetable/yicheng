import cn.studio.zps.blue.ljy.dao.ProfessionCoursePictureDao;
import cn.studio.zps.blue.ljy.domain.ProfessionCoursePicture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Text {
    @Autowired
    private ProfessionCoursePictureDao professionCoursePictureDao;
    @Test
    public void test1() {
        ProfessionCoursePicture professionCoursePicture = new ProfessionCoursePicture();
        System.out.println(professionCoursePictureDao.getProfessionCoursePictureByID(1));
    }
}
