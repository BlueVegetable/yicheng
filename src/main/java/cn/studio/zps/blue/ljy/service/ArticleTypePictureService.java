package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.ArticleTypePicture;

import java.util.List;
import java.util.Map;

public interface ArticleTypePictureService {
    Map addArticleTypePicture(ArticleTypePicture articleTypePicture);
    boolean deleteArticleTypePicture(int id);
    ArticleTypePicture getArticleTypePictureByID(int articleTypePictureID);
    List<ArticleTypePicture> getAllArticleTypePictures();
    boolean updateArticleTypePicture(ArticleTypePicture articleTypePicture);
}
