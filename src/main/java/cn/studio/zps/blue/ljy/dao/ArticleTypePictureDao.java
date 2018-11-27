package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.ArticleTypePicture;

import java.util.List;

public interface ArticleTypePictureDao {
    int addArticleTypePicture(ArticleTypePicture modulePicture);
    int deleteArticleTypePicture(int id);
    Long count(int moduleID);
    ArticleTypePicture getArticleTypePictureByID(int id);
    List<ArticleTypePicture> getArticleTypePicturesByArticleTypeID(int articleTypeID);
    List<ArticleTypePicture> getAllArticleTypePictures();
    int updateArticleTypePicture(ArticleTypePicture modulePicture);
}
