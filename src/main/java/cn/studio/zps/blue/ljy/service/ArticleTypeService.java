package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.ArticleType;

import java.util.List;

public interface ArticleTypeService {
    boolean addArticleType(ArticleType articleType);
    List<ArticleType> getAllArticleTypesByModuleID(int moduleID);
    List<ArticleType> getAllArticleTypes(Integer moduleID,Integer page,Integer limit);
    Long countArticleTypes(Integer moduleID);
    String getArticleTypeByTypeID(int typeID);
    ArticleType getArticleTypeByArticleID(int articleID);
    boolean deleteArticleType(int typeID);
    boolean alterArticleTypeName(int id,String newName,String url);
}
