package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDao {

    int addArticle(@Param("article") Article article,@Param("adminID") int adminID);

    int deleteArticle(int articleID);

    /**
     * 计算在限定管理员，限定标题的文章的数量
     * @param adminID
     * @param title
     * @return
     */
    int countLimit(@Param("adminID") int adminID,@Param("title") String title);

    Article getArticle(int articleID);

    List<Article> getAllArticles(int adminID);

    int getAllArticlesCount(int adminID);

    int updateArticle(Article article);

}
