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
    public List<ArticleType> getAllArticleTypes(Integer moduleID,Integer page,Integer limit) {
        Integer start;
        start = page!=null?(page-1)*10:null;
        return articleTypeDao.getAllArticleTypes(moduleID,start,limit);
    }

    @Override
    public Long countArticleTypes(Integer moduleID) {
        return articleTypeDao.countArticleTypes(moduleID);
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
    public boolean alterArticleTypeName(int id, String newName,String url) {
        return articleTypeDao.alterArticleTypeName(id,newName,url) > 0;
    }
}
