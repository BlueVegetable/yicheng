package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.Article;
import cn.studio.zps.blue.ljy.service.ArticleService;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ResponseBody
    @RequestMapping(value="addArticle",method = RequestMethod.POST)
    public Map<String,Object> addArticle(@RequestBody Article article) {
        article.setLastModify(new Timestamp(System.currentTimeMillis()));
        if(articleService.addArticle(article)) {
            return Response.getResponseMap(0,"",null);
        } else {
            return Response.getResponseMap(1,"添加失败",null);
        }
    }

    @ResponseBody
    @RequestMapping("deleteArticle")
    public Map<String,Object> deleteArticle(int articleID) {
        if(articleService.deleteArticle(articleID)) {
            return Response.getResponseMap(0,"",null);
        } else {
            return Response.getResponseMap(1,"删除失败",null);
        }
    }

    @RequestMapping("getArticle")
    @ResponseBody
    public Map<String,Object> getArticle(int articleID) {
        Article article = articleService.getArticle(articleID);
        return Response.getResponseMap(0,"",article);
    }

    @ResponseBody
    @RequestMapping("getAllArticles")
    public Map<String,Object> getAllArticles() {
        List<Article> articles = articleService.getAllArticle();
        return Response.getResponseMap(0,"",articles);
    }

    @ResponseBody
    @RequestMapping("updateArticle")
    public Map<String,Object> updateArticle(@RequestBody Article article) {
        article.setLastModify(new Timestamp(System.currentTimeMillis()));
        if(articleService.updateArticle(article)) {
            return Response.getResponseMap(0,"",null);
        } else {
            return Response.getResponseMap(1,"修改失败",null);
        }
    }

}
