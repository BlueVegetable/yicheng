package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.ArticleType;

import java.util.List;

public interface ArticleTypeDao {

    List<ArticleType> getAllArticleTypes();

    String getArticleTypeByTypeID(int typeID);

}
