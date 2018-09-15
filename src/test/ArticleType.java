import cn.studio.zps.blue.ljy.dao.ArticleTypeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ArticleType {

    @Autowired
    private ArticleTypeDao articleTypeDao;

    @Test
    public void test1() {
        System.out.println(articleTypeDao.getAllArticleTypes());
    }

}
