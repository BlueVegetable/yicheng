package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.Admin;
import cn.studio.zps.blue.ljy.domain.Article;
import cn.studio.zps.blue.ljy.service.ArticleService;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("article")
public class ArticleController {

    private @Autowired ArticleService articleService;

    @ResponseBody
    @RequestMapping(value="addArticle",method = RequestMethod.POST)
    public Map<String,Object> addArticle(@RequestBody Article article , HttpServletRequest request) {
        System.out.println(article);
        Admin admin = (Admin) request.getAttribute("admin");
        if(articleService.exist(admin.getId(),article.getTitle())) {
            return Response.getResponseMap(1,"文章已存在",null);
        }
        article.setLastModify(new Timestamp(System.currentTimeMillis()));
        if(articleService.addArticle(article,admin.getId())) {
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

    public @RequestMapping("getArticleInfo") @ResponseBody Map getArticleInfo(int articleID) {
        Map result = new HashMap();
        Article article = articleService.getArticle(articleID);
        result.put("article",article);
        Integer previous = articleService.getPreviousArticleTypeID(articleID,article.getTypeID());
        Integer next = articleService.getNextArticleTypeID(articleID,article.getTypeID());
        String previousTitle,nextTitle;
        if(previous == null) {
            previousTitle = null;
        } else {
            previousTitle = articleService.getArticle(previous).getTitle();
        }
        if(next == null) {
            nextTitle = null;
        } else {
            nextTitle = articleService.getArticle(next).getTitle();
        }
        result.put("previousArticleID",previous);
        result.put("nextArticleID",next);
        result.put("previousTitle",previousTitle);
        result.put("nextTitle",nextTitle);
        return result;
    }

    @ResponseBody
    @RequestMapping("getAllArticles")
    public Map<String,Object> getAllArticles(@RequestParam("page") int page,@RequestParam("limit") int limit) {
//        Admin admin = (Admin) request.getAttribute("admin");
//        int adminID = admin.getId();
        Map<String,Object>result = articleService.getAllArticle(page,limit);
        result.put("code",0);
        result.put("msg","");
        return result;
    }

    @RequestMapping("getArticles")
    public @ResponseBody List<Article> getArticles(@RequestParam("typeID") int typeID) {
        return articleService.getArticles(typeID);
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
