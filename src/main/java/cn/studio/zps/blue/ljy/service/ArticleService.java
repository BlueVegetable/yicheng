package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.Article;

import java.util.List;
import java.util.Map;

public interface ArticleService {

    boolean addArticle(Article article,int adminID);

    boolean deleteArticle(int articleID);

    boolean exist(int adminID,String title);

    Article getArticle(int articleID);

    Map<String, Object> getAllArticle(int page,int limit);

    boolean updateArticle(Article article);

}
