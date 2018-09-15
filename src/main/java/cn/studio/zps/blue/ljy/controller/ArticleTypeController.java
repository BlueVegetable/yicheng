package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.ArticleType;
import cn.studio.zps.blue.ljy.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("articleType")
public class ArticleTypeController {

    @Autowired
    private ArticleTypeService articleTypeService;

    @ResponseBody
    @RequestMapping("getAllArticleTypes")
    public List<ArticleType> getAllArticleTypes() {
        return articleTypeService.getAllArticleTypes();
    }

}
