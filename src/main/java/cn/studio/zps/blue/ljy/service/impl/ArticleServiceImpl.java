package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.ArticleDao;
import cn.studio.zps.blue.ljy.domain.Article;
import cn.studio.zps.blue.ljy.service.ArticleService;
import cn.studio.zps.blue.ljy.utils.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;
    /**
     * 资讯文章的数量
     */
    private final static int CONSULT_NUMBER = 10;

    @Override
    public boolean addArticle(Article article,int adminID) {
//        Pattern pattern1 = Pattern.compile("<img\\s*((?<key>[^=]+)=\"*(?<value>[^\"]+)\")+?\\s*/?>");
//        Matcher matcher1 = pattern1.matcher(article.getContent());
//        article.setBrief(matcher1.replaceAll("[图片]").substring(0,50)+"······");
        String brief = article.getBrief();
        if(brief.length()>50) {
            article.setBrief(brief.substring(0,46)+"···");
        }
        return articleDao.addArticle(article,adminID)>0;
    }

    @Override
    public boolean exist(int adminID, String title) {
        return articleDao.exist(adminID,title);
    }

    @Override
    public boolean deleteArticle(int articleID) {
        Article article = articleDao.getArticle(articleID);
        boolean flag = articleDao.deleteArticle(articleID)>0;
        if(flag) {
            List<String> files = getArticleFile(article.getContent());
            for(String file : files) {
                FileUpload.deleteUeditorImage(file);
                FileUpload.deleteUeditorVideo(file);
            }
        }
        return flag;
    }

    private List<String> getArticleFile(String article) {
        List<String> files = new ArrayList<>();
        String regex = "(?i)(k1|k2|label|src)[=\"\'\\s]+([^\"\']*)(?=[\"\'\\s>]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(article);
        while (matcher.find()) {
            String origin = matcher.group(2);
            String result;
            if(origin.contains("/")) {
                result = origin.substring(origin.lastIndexOf('/'));
            } else {
                result = origin;
            }
            files.add(result);
        }
        return files;
    }

    @Override
    public Article getArticle(int articleID) {
        return articleDao.getArticle(articleID);
    }

    @Override
    public Map<String, Object> getAllArticle(int page,int limit,Integer articleTypeID,String title) {
        Map<String,Object> result = new HashMap<>(2);
        int start = (page-1) * limit;
        result.put("data",articleDao.getAllArticles(start,limit,articleTypeID,title));
        result.put("count",articleDao.getAllArticlesCount(articleTypeID, title));
        return result;
    }

    @Override
    public List<Article> getArticles(Integer typeID) {
        return articleDao.getArticles(typeID);
    }

    @Override
    public Integer getPreviousArticleTypeID(int id, int articleTypeID) {
        return articleDao.getPreviousArticleTypeID(id,articleTypeID);
    }

    @Override
    public Integer getNextArticleTypeID(int id, int articleTypeID) {
        return articleDao.getNextArticleTypeID(id,articleTypeID);
    }

    @Override
    public List<Article> getArticlesByModuleID(Integer moduleID) {
        return articleDao.getArticlesByModuleID(moduleID);
    }

    @Override
    public List<Article> getAllArticlesByConsult(Integer moduleID) {
        List<Article> result = articleDao.getAllArticlesByConsult(moduleID);
        int number = 10-result.size();
        if(number > 0 && number< CONSULT_NUMBER) {
            for (int i=0;i<number;i++) {
                result.add(result.get(i));
            }
        } else if(number==CONSULT_NUMBER) {
            List<Article> notConsultArticle = articleDao.getArticlesByModuleID(moduleID);
            if(notConsultArticle.size()>CONSULT_NUMBER) {
                for (int i=0;i<CONSULT_NUMBER;i++) {
                    result.add(notConsultArticle.get(i));
                }
            } else if(notConsultArticle.size() == CONSULT_NUMBER) {
                result = notConsultArticle;
            } else {
                result = notConsultArticle;
                number = 10 - result.size();
                for (int i=0;i<number;i++) {
                    result.add(result.get(i));
                }
            }
        }
        for (Article article:result) {
            article.setContent(null);
        }
        return result;
    }

    @Override
    public boolean updateArticle(Article article) {
        return articleDao.updateArticle(article)>0;
    }
}
