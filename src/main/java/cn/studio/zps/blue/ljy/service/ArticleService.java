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

    List<Article> getArticles(Integer typeID);

    List<Article> getArticlesByModuleID(Integer moduleID);

    List<Article> getAllArticlesByConsult(Integer moduleID);

    boolean updateArticle(Article article);

}
