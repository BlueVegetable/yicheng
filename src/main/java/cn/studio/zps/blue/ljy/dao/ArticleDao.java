package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDao {

    int addArticle(@Param("article") Article article,@Param("adminID") int adminID);

    int deleteArticle(int articleID);

    boolean exist(@Param("adminID") int adminID,@Param("title") String title);

    Article getArticle(int articleID);

    List<Article> getAllArticles();

    int getAllArticlesCount();

    int updateArticle(Article article);

}
