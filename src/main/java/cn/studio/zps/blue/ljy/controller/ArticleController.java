package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.Admin;
import cn.studio.zps.blue.ljy.domain.Article;
import cn.studio.zps.blue.ljy.service.ArticleService;
import cn.studio.zps.blue.ljy.service.ArticleTypeService;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("article")
public class ArticleController {

    private @Autowired ArticleService articleService;

    @ResponseBody
    @RequestMapping(value="addArticle",method = RequestMethod.POST)
    public Map<String,Object> addArticle(@RequestBody Article article , HttpServletRequest request) {
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
    public @ResponseBody List<Article> getArticles(@RequestParam("typeID") int typeID,@RequestParam("number") int number) {
        return articleService.getArticles(typeID,number);
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
