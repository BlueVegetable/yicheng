package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.ArticleType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleTypeDao {

    int addArticleType(ArticleType articleType);

    List<ArticleType> getAllArticleTypesByModuleID(int moduleID);

    List<ArticleType> getAllArticleTypes();

    String getArticleTypeByTypeID(int typeID);

    int deleteArticleType(int typeID);

    int alterArticleTypeName(@Param("typeID") int typeID,@Param("name") String name,
                             @Param("url") String url);

}
