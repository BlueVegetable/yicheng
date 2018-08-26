package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDao {

    int addArticle(@Param("article") Article article,@Param("adminID") int adminID);

    int deleteArticle(int articleID);

    /**
     * 计算有用户，标题限定的数量
     * @param adminID
     * @param title
     * @return
     */
    int countLimit(@Param("adminID") int adminID,@Param("title") String title);

    Article getArticle(int articleID);

    List<Article> getAllArticles(int adminID);

    int updateArticle(Article article);

}
