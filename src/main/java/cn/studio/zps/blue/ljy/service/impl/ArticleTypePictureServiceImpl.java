package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.ArticleTypePictureDao;
import cn.studio.zps.blue.ljy.domain.ArticleTypePicture;
import cn.studio.zps.blue.ljy.service.ArticleTypePictureService;
import cn.studio.zps.blue.ljy.utils.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public @Service class ArticleTypePictureServiceImpl implements ArticleTypePictureService {
    private @Autowired
    ArticleTypePictureDao articleTypePictureDao;
    private static final int MAX_NUMBER = 1;
    @Override
    public Map addArticleTypePicture(ArticleTypePicture articleTypePicture) {
        Map result = new HashMap();
        long number = articleTypePictureDao.count(articleTypePicture.getArticleTypeID());
        if (number >= MAX_NUMBER) {
            result.put("code",false);
            result.put("msg","图片超过了限度");
            return result;
        }
        if(articleTypePictureDao.addArticleTypePicture(articleTypePicture) > 0) {
            result.put("code",true);
            result.put("msg",null);
        } else {
            result.put("code",false);
            result.put("msg","服务器出错");
        }
        return result;
    }

    @Override
    public boolean deleteArticleTypePicture(int id) {
        ArticleTypePicture articleTypePicture = articleTypePictureDao.getArticleTypePictureByID(id);
        FileUpload.deleteArticleTypePicture(articleTypePicture.getPath());
        return articleTypePictureDao.deleteArticleTypePicture(id) > 0;
    }

    @Override
    public ArticleTypePicture getArticleTypePictureByID(int articleTypePictureID) {
        return articleTypePictureDao.getArticleTypePictureByID(articleTypePictureID);
    }

    @Override
    public List<ArticleTypePicture> getArticleTypePicturesByArticleTypeID(int articleTypeID) {
        return articleTypePictureDao.getArticleTypePicturesByArticleTypeID(articleTypeID);
    }

    @Override
    public List<ArticleTypePicture> getAllArticleTypePictures() {
        return articleTypePictureDao.getAllArticleTypePictures();
    }

    @Override
    public boolean updateArticleTypePicture(ArticleTypePicture articleTypePicture) {
        ArticleTypePicture origin = articleTypePictureDao.getArticleTypePictureByID(articleTypePicture.getId());
        if (!origin.getPath().equals(articleTypePicture.getPath())) {
            FileUpload.deleteArticleTypePicture(origin.getPath());
        }
        return articleTypePictureDao.updateArticleTypePicture(articleTypePicture) > 0;
    }
}
