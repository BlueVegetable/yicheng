package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.Article;

import java.util.List;

public interface ArticleService {

    boolean addArticle(Article article,int adminID);

    boolean deleteArticle(int articleID);

    boolean exist(int adminID,String title);

    Article getArticle(int articleID);

    List<Article> getAllArticle(int adminID);

    boolean updateArticle(Article article);

}
