package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.Article;
import cn.studio.zps.blue.ljy.domain.ArticleType;
import cn.studio.zps.blue.ljy.domain.Module;
import cn.studio.zps.blue.ljy.service.ArticleService;
import cn.studio.zps.blue.ljy.service.ArticleTypeService;
import cn.studio.zps.blue.ljy.service.BannerPCService;
import cn.studio.zps.blue.ljy.service.ModuleService;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@RequestMapping("module")
public @Controller class ModuleController {
    private @Autowired ModuleService moduleService;
    private @Autowired BannerPCService bannerPCService;
    private @Autowired ArticleService articleService;
    private @Autowired ArticleTypeService articleTypeService;
    @RequestMapping("addModule")
    public @ResponseBody boolean addModule(Module module) {
        return moduleService.addModule(module);
    }
    @RequestMapping("deleteModule")
    public @ResponseBody boolean deleteModule(int moduleID) {
        return moduleService.deleteModule(moduleID);
    }
    @RequestMapping("getModuleByID")
    public @ResponseBody Map<String,Object> getModuleByID(@RequestParam("moduleID")int moduleID) {
        Module module = moduleService.getModuleByID(moduleID);
        if(module == null) {
            return Response.getResponseMap(1,"无此模块",null);
        } else {
            return Response.getResponseMap(0,"",module);
        }
    }
    @RequestMapping("getModuleByTypeID")
    public @ResponseBody Module getModuleByTypeID(@RequestParam("typeID") int typeID) {
        return moduleService.getModuleByTypeID(typeID);
    }
    @RequestMapping("getAllModules")
    public @ResponseBody List<Module> getAllModules() {
        return moduleService.getAllModules();
    }
    @RequestMapping("getModuleInfo")
    public @ResponseBody Map getModuleInfo(@RequestParam("moduleID") int moduleID) {
        Map<String,Object> result = Response.getResponseMap(0,"",null);
        try {
            Map data = new HashMap();
            data.put("banner-pc",bannerPCService.getBannerPCsByLocation(moduleID));
            Map<String,List<Article>> articles = new LinkedHashMap<>();
            List<ArticleType> articleTypes = articleTypeService.getAllArticleTypesByModuleID(moduleID);
            List<Article> all = articleService.getArticlesByModuleID(moduleID);
            articles.put("全部",all);
            for (ArticleType articleType:articleTypes) {
                articles.put(articleType.getType(),articleService.getArticles(articleType.getId()));
            }
            articles.remove("咨询");
            data.put("articles",articles);
            List<Article> consult = articleService.getAllArticlesByConsult(moduleID);
            data.put("consult", consult);
            all.removeAll(consult);
            result.put("data",data);
        } catch (Exception e) {
            e.printStackTrace();
            result = Response.getResponseMap(1,"服务器出错",null);
        }
        return result;
    }
}
