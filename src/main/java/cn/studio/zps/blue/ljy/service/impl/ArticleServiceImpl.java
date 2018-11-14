package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.ArticleDao;
import cn.studio.zps.blue.ljy.domain.Article;
import cn.studio.zps.blue.ljy.service.ArticleService;
import cn.studio.zps.blue.ljy.utils.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public boolean addArticle(Article article,int adminID) {
//        Pattern pattern1 = Pattern.compile("<img\\s*((?<key>[^=]+)=\"*(?<value>[^\"]+)\")+?\\s*/?>");
//        Matcher matcher1 = pattern1.matcher(article.getContent());
//        article.setBrief(matcher1.replaceAll("[图片]").substring(0,50)+"······");
        return articleDao.addArticle(article,adminID)>0;
    }

    @Override
    public boolean exist(int adminID, String title) {
        return articleDao.exist(adminID,title);
    }

    @Override
    public boolean deleteArticle(int articleID) {
        Article article = articleDao.getArticle(articleID);
        boolean flag = articleDao.deleteArticle(articleID)>0;
        if(flag) {
            List<String> files = getArticleFile(article.getContent());
            for(String file : files) {
                FileUpload.deleteUeditorImage(file);
                FileUpload.deleteUeditorVideo(file);
            }
        }
        return flag;
    }

    private List<String> getArticleFile(String article) {
        List<String> files = new ArrayList<>();
        String regex = "(?i)(k1|k2|label|src)[=\"\'\\s]+([^\"\']*)(?=[\"\'\\s>]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(article);
        while (matcher.find()) {
            String origin = matcher.group(2);
            String result;
            if(origin.contains("/")) {
                result = origin.substring(origin.lastIndexOf('/'));
            } else {
                result = origin;
            }
            files.add(result);
        }
        return files;
    }

    @Override
    public Article getArticle(int articleID) {
        return articleDao.getArticle(articleID);
    }

    @Override
    public Map<String, Object> getAllArticle(int page,int limit) {
        Map<String,Object> result = new HashMap<>(2);
        int start = (page-1) * limit;
        result.put("data",articleDao.getAllArticles(start,limit));
        result.put("count",articleDao.getAllArticlesCount());
        return result;
    }

    @Override
    public List<Article> getArticles(Integer typeID) {
        return articleDao.getArticles(typeID);
    }

    @Override
    public List<Article> getArticlesByModuleID(Integer moduleID) {
        return articleDao.getArticlesByModuleID(moduleID);
    }

    @Override
    public List<Article> getAllArticlesByConsult(Integer moduleID) {
        return articleDao.getAllArticlesByConsult(moduleID);
    }

    @Override
    public boolean updateArticle(Article article) {
        return articleDao.updateArticle(article)>0;
    }
}
