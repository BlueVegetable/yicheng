import cn.studio.zps.blue.ljy.dao.*;
import cn.studio.zps.blue.ljy.domain.EducationLevel;
import cn.studio.zps.blue.ljy.utils.QiNiuUpload;
import com.qiniu.common.QiniuException;
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
    @Autowired
    private EducationLevelDao educationLevelDao;
    public @Test void test() throws QiniuException {
        System.out.println(QiNiuUpload.uploadVideo("E:\\我的视频\\其他\\【末日时在做什么】斯卡布罗集市（1080P合集） - 2.第十二集(Av11744252,P2).Flv"));
    }
    public @Test void test2() {
        System.out.println("www.baidu.com".startsWith("https://"));
    }
    public @Test void test3() {
        EducationLevel educationLevel = new EducationLevel();
        educationLevel.setId(1);
        educationLevel.setName("中学");
        educationLevel.setVisible((byte)1);
        System.out.println(educationLevelDao.updateEducationLevel(educationLevel));
    }
}
