import cn.studio.zps.blue.ljy.dao.ArticleDao;
import cn.studio.zps.blue.ljy.dao.ConsultDao;
import cn.studio.zps.blue.ljy.service.ConsultService;
import cn.studio.zps.blue.ljy.service.ModuleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ConsultTest {

    @Autowired
    private ConsultDao consultDao;

    @Autowired
    private ConsultService consultService;
    private @Autowired ModuleService moduleService;
    private @Autowired ArticleDao articleDao;

    public @Test void test1() {
        List<Short> parameters = new ArrayList<>();
        parameters.add((short)0);
        parameters.add((short)1);
        parameters.add((short)2);
        parameters.add((short)3);
        parameters.add((short)4);
        parameters.add((short)5);
        System.out.println(consultService.countByState(parameters));
    }
    public @Test void test2() {
        System.out.println();
    }
    public @Test void test3() {
        System.out.println(consultDao.getLimitNumberClassfy(5));
    }
    public @Test void test4() {
        Pattern pattern = Pattern.compile("<img\\s*((?<key>[^=]+)=\"*(?<value>[^\"]+)\")+?\\s*/?>");
        String origin = "<img src=\"http://localhost:80/upload/ueditor/image/1535954859039-1244994524-2147483647.jpeg\" title=\"1535954859039-1244994524-2147483647.jpeg\" alt=\"1535954859039-1244994524-2147483647.jpeg\" width=\"621\" height=\"318\"/>" +
                "hahahaha<img src=\"http://localhost:80/upload/ueditor/image/1535954859039-1244994524-2147483647.jpeg\" title=\"1535954859039-1244994524-2147483647.jpeg\" alt=\"1535954859039-1244994524-2147483647.jpeg\" width=\"621\" height=\"318\"/>";
        String now = new String(origin);
        Matcher matcher = pattern.matcher(now);
        now = matcher.replaceAll("[图片]");
        System.out.println(now);
    }
    public @Test void test5() {
        System.out.println(moduleService.getAllModules());
    }
    public @Test void test6() {
        System.out.println(articleDao.getPreviousArticleTypeID(5,1));
    }
    public @Test void test7() {
        System.out.println(articleDao.getArticle(1));
    }
}
