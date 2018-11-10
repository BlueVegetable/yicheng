package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.ArticleTypeDao;
import cn.studio.zps.blue.ljy.domain.ArticleType;
import cn.studio.zps.blue.ljy.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {

    @Autowired
    private ArticleTypeDao articleTypeDao;

    @Override
    public boolean addArticleType(ArticleType articleType) {
        return articleTypeDao.addArticleType(articleType) > 0;
    }

    @Override
    public List<ArticleType> getAllArticleTypesByModuleID(int moduleID) {
        return articleTypeDao.getAllArticleTypesByModuleID(moduleID);
    }

    @Override
    public List<ArticleType> getAllArticleTypes() {
        return articleTypeDao.getAllArticleTypes();
    }

    @Override
    public String getArticleTypeByTypeID(int typeID) {
        return articleTypeDao.getArticleTypeByTypeID(typeID);
    }

    @Override
    public boolean deleteArticleType(int typeID) {
        return articleTypeDao.deleteArticleType(typeID) > 0;
    }

    @Override
    public boolean alterArticleTypeName(int id, String newName) {
        return articleTypeDao.alterArticleTypeName(id,newName) > 0;
    }
}
