package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.ArticleType;

import java.util.List;

public interface ArticleTypeService {
    boolean addArticleType(ArticleType articleType);
    List<ArticleType> getAllArticleTypesByModuleID(int moduleID);
    List<ArticleType> getAllArticleTypes();
    String getArticleTypeByTypeID(int typeID);
    boolean deleteArticleType(int typeID);
    boolean alterArticleTypeName(int id,String newName,String url);
}
