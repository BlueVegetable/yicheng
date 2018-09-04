package service;

import cn.studio.zps.blue.ljy.service.ArticleService;
import cn.studio.zps.blue.ljy.service.impl.ArticleServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ArticleTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void test1() {
//        articleServiceImpl.deleteArticleFile("<img src='' />");
        String article = null;
        article = "<img src='aaa.jpg' /> <video src='bbb.mp4' >";
//        System.out.println(articleService.getArticleFile(article));
    }

}
