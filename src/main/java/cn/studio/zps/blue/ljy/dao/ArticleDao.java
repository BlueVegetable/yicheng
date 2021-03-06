package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDao {

    int addArticle(@Param("article") Article article,@Param("adminID") int adminID);

    int deleteArticle(int articleID);

    boolean exist(@Param("adminID") int adminID,@Param("title") String title);

    Article getArticle(int articleID);

    List<Article> getAllArticles(@Param("start") int start,@Param("number") int number,
                                 @Param("articleTypeID")Integer articleTypeID, @Param("title")String title);

    Integer getPreviousArticleTypeID(@Param("articleID") int id, @Param("articleTypeID") int articleTypeID);

    Integer getNextArticleTypeID(@Param("articleID") int id, @Param("articleTypeID") int articleTypeID);

    int getAllArticlesCount(@Param("articleTypeID")Integer articleTypeID, @Param("title")String title);

    List<Article> getArticles(@Param("typeID")Integer typeID);

    List<Article> getArticlesByModuleID(@Param("moduleID") Integer moduleID);

    List<Article> getAllArticlesByConsult(Integer moduleID);

    int updateArticle(Article article);

}
