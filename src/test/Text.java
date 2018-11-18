import cn.studio.zps.blue.ljy.dao.CourseDao;
import cn.studio.zps.blue.ljy.dao.CourseModuleDao;
import cn.studio.zps.blue.ljy.dao.CourseTypeDao;
import cn.studio.zps.blue.ljy.dao.VideoDao;
import cn.studio.zps.blue.ljy.domain.CourseModule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Text {
    private @Autowired VideoDao videoDao;
    private @Autowired CourseDao courseDao;
    private @Autowired CourseTypeDao courseTypeDao;
    private @Autowired CourseModuleDao courseModuleDao;
    public @Test void test() {
        System.out.println(courseModuleDao.getCourseModuleByID(1));
    }
}
