package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.ArticleType;

import java.util.List;

public interface ArticleTypeService {

    List<ArticleType> getAllArticleTypes();

    String getArticleTypeByTypeID(int typeID);

}
