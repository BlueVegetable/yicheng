package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.Article;

import java.util.List;

public interface ArticleService {

    boolean addArticle(Article article);

    boolean deleteArticle(int articleID);

    Article getArticle(int articleID);

    List<Article> getAllArticle();

    boolean updateArticle(Article article);

}
