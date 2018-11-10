package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.ArticleType;
import cn.studio.zps.blue.ljy.service.ArticleTypeService;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("articleType")
public class ArticleTypeController {

    @Autowired
    private ArticleTypeService articleTypeService;

    @RequestMapping("addArticleType")
    public @ResponseBody Map addArticleType(ArticleType articleType) {
        if(articleTypeService.addArticleType(articleType))
            return Response.getResponseMap(0,"",true);
        else {
            return Response.getResponseMap(1,"服务器出错",false);
        }
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

    @RequestMapping("getAllArticleTypes")
    public @ResponseBody Map getAllArticleTypes() {
        List<ArticleType> data = articleTypeService.getAllArticleTypes();
        Map result = Response.getResponseMap(0,"",data);
        result.put("count",result.size());
        return result;
    }

    @RequestMapping("getArticleTypeByTypeID")
    public @ResponseBody Map<String,Object> getArticleTypeByTypeID(int typeID) {
        String value = articleTypeService.getArticleTypeByTypeID(typeID);
        if(value == null) {
            return Response.getResponseMap(1,"不存在",null);
        } else {
            return Response.getResponseMap(0,"",value);
        }
    }

    @RequestMapping("deleteArticleType")
    public @ResponseBody Map deleteArticleType(int articleTypeID) {
        if (articleTypeService.deleteArticleType(articleTypeID)) {
            return Response.getResponseMap(0,"",true);
        } else {
            return Response.getResponseMap(1,"删除失败",false);
        }
    }

    @RequestMapping("alterArticleTypeName")
    public @ResponseBody Map alterArticleTypeName(int id,String name) {
        try {
            if(articleTypeService.alterArticleTypeName(id,name)) {
                return Response.getResponseMap(0, "", true);
            }
            else {
                return Response.getResponseMap(1,"修改失败",false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.getResponseMap(1,"服务器出错",false);
        }
    }

}
