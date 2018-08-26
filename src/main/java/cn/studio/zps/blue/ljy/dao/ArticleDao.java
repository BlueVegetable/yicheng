package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Article;

import java.util.List;

public interface ArticleDao {

    int addArticle(Article article);

    int deleteArticle(int articleID);

    Article getArticle(int articleID);

    List<Article> getAllArticles();

    int updateArticle(Article article);

}
