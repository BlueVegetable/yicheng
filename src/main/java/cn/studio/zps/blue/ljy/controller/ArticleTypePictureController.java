package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.ArticleTypePicture;
import cn.studio.zps.blue.ljy.service.ArticleTypePictureService;
import cn.studio.zps.blue.ljy.utils.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public @Controller @RequestMapping("articleTypePicture") class ArticleTypePictureController {
    private @Autowired ArticleTypePictureService articleTypePictureService;
    private static final String DIRECTORY="/articleTypePicture";
    public @ResponseBody @RequestMapping("uploadArticleTypePicture") Map uploadArticleTypePicture(MultipartFile file){
        Map<String,Object> value = FileUpload.copyArticleTypePicture(file);
        String name = (String) value.get("fileName");
        String msg = value.get("code").equals("SUCCESS")?"":"上传失败";
        int code = value.get("code").equals("SUCCESS")?0:1;

        Map<String,Object> data = new HashMap<>(2);
        data.put("path",DIRECTORY+"/"+name);
        data.put("type", value.get("fileType"));

        Map<String,Object> result = new HashMap<>(3);
        result.put("code",code);
        result.put("msg",msg);
        result.put("data",data);
        return result;
    }
    public @ResponseBody @RequestMapping("addArticleTypePicture") Map addArticleTypePicture(ArticleTypePicture articleTypePicture) {
        if(articleTypePicture.getUrl().equals("")) {
            articleTypePicture.setUrl(null);
        }
        String url = articleTypePicture.getUrl();
        if(url!=null&&!url.startsWith("https://")&&!url.startsWith("http://")) {
            url = "http://" + url;
            articleTypePicture.setUrl(url);
        }
        return articleTypePictureService.addArticleTypePicture(articleTypePicture);
    }
    public @ResponseBody @RequestMapping("deleteArticleTypePicture") boolean deleteArticleTypePicture(int articleTypePictureID) {
        return articleTypePictureService.deleteArticleTypePicture(articleTypePictureID);
    }
    public @ResponseBody @RequestMapping("getArticleTypePictureByID") ArticleTypePicture getArticleTypePictureByID(int articleTypePictureID) {
        return articleTypePictureService.getArticleTypePictureByID(articleTypePictureID);
    }
    public @ResponseBody @RequestMapping("getArticleTypePicturesByArticleTypeID") List<ArticleTypePicture> getArticleTypePicturesByArticleTypeID(int articleTypeID) {
        return articleTypePictureService.getArticleTypePicturesByArticleTypeID(articleTypeID);
    }
    public @ResponseBody @RequestMapping("getAllArticleTypePicturesDeal") Map getAllArticleTypePicturesDeal() {
        Map result = new HashMap();
        List<ArticleTypePicture> datas;
        try {
            datas = articleTypePictureService.getAllArticleTypePictures();
            result.put("code",0);
            result.put("msg","");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code",1);
            result.put("msg","服务器查不到数据");
            datas = new ArrayList<>();
        }
        result.put("data",datas);
        return result;
    }
    public @ResponseBody @RequestMapping("updateArticleTypePicture") boolean updateArticleTypePicture(ArticleTypePicture articleTypePicture) {
        if(articleTypePicture.getUrl().equals("")) {
            articleTypePicture.setUrl(null);
        }
        String url = articleTypePicture.getUrl();
        if(url!=null&&!url.startsWith("https://")&&!url.startsWith("http://")) {
            url = "http://" + url;
            articleTypePicture.setUrl(url);
        }
        return articleTypePictureService.updateArticleTypePicture(articleTypePicture);
    }
}