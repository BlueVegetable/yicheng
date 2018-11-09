package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.Article;
import cn.studio.zps.blue.ljy.domain.ArticleType;
import cn.studio.zps.blue.ljy.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("articleType")
public class ArticleTypeController {

    @Autowired
    private ArticleTypeService articleTypeService;

    @RequestMapping("addArticleType")
    public @ResponseBody boolean addArticleType(ArticleType articleType) {
        return articleTypeService.addArticleType(articleType);
    }

    @ResponseBody
    @RequestMapping("getAllArticleTypesByModuleID")
    public List<ArticleType> getAllArticleTypesByModuleID(Integer moduleID) {
        if(moduleID != null) {
            return articleTypeService.getAllArticleTypesByModuleID(moduleID);
        } else {
            return new ArrayList<>();
        }
    }

    @RequestMapping("getArticleTypeByTypeID")
    public @ResponseBody String getArticleTypeByTypeID(int typeID) {
        return articleTypeService.getArticleTypeByTypeID(typeID);
    }

    @RequestMapping("deleteArticleType")
    public @ResponseBody boolean deleteArticleType(int articleTypeID) {
        return articleTypeService.deleteArticleType(articleTypeID);
    }

    @RequestMapping("alterArticleTypeName")
    public @ResponseBody boolean alterArticleTypeName(int id,String name) {
        return articleTypeService.alterArticleTypeName(id,name);
    }

}
