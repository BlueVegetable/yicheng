package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Article;
import cn.studio.zps.blue.ljy.domain.ArticleType;

import java.util.List;

public interface ArticleTypeDao {

    int addArticleType(ArticleType articleType);

    List<ArticleType> getAllArticleTypesByModuleID(int moduleID);

    String getArticleTypeByTypeID(int typeID);

    int deleteArticleType(int typeID);

    int alterArticleTypeName(int typeID,String name);

}
