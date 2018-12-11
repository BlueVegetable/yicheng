import cn.studio.zps.blue.ljy.dao.CourseDao;
import cn.studio.zps.blue.ljy.dao.CourseModuleDao;
import cn.studio.zps.blue.ljy.dao.CourseTypeDao;
import cn.studio.zps.blue.ljy.dao.VideoDao;
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
    public @Test void test() throws QiniuException {
        System.out.println(QiNiuUpload.uploadVideo("E:\\我的视频\\其他\\【末日时在做什么】斯卡布罗集市（1080P合集） - 2.第十二集(Av11744252,P2).Flv"));
    }
    public @Test void test2() {
        System.out.println("www.baidu.com".startsWith("https://"));
    }
}
