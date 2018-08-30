package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.ArticleDao;
import cn.studio.zps.blue.ljy.domain.Article;
import cn.studio.zps.blue.ljy.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public boolean addArticle(Article article,int adminID) {
        return articleDao.addArticle(article,adminID)>0;
    }

    @Override
    public boolean exist(int adminID, String title) {
        return articleDao.exist(adminID,title);
    }

    @Override
    public boolean deleteArticle(int articleID) {
        return articleDao.deleteArticle(articleID)>0;
    }

    @Override
    public Article getArticle(int articleID) {
        return articleDao.getArticle(articleID);
    }

    @Override
    public Map<String, Object> getAllArticle(int adminID) {
        Map<String,Object> result = new HashMap<>(2);
        result.put("data",articleDao.getAllArticles(adminID));
        result.put("count",articleDao.getAllArticlesCount(adminID));
        return result;
    }

    @Override
    public boolean updateArticle(Article article) {
        return articleDao.updateArticle(article)>0;
    }
}
