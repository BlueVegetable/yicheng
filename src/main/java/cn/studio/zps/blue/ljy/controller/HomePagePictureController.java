package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.HomePagePicture;
import cn.studio.zps.blue.ljy.service.HomePagePictureService;
import cn.studio.zps.blue.ljy.utils.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public @Controller @RequestMapping("homePagePicture") class HomePagePictureController {
    private @Autowired HomePagePictureService homePagePictureService;
    private static final String DIRECTORY="/homePagePicture";
    public @ResponseBody @RequestMapping("uploadHomePagePicture") Map uploadHomePagePicture(MultipartFile file){
        Map<String,Object> value = FileUpload.copyHomePagePicture(file);
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
    public @ResponseBody @RequestMapping("addHomePagePicture") Map addHomePagePicture(HomePagePicture homePagePicture) {
        if(homePagePicture.getUrl().equals("")) {
            homePagePicture.setUrl(null);
        }
        String url = homePagePicture.getUrl();
        if(url!=null&&!url.startsWith("https://")&&!url.startsWith("http://")) {
            url = "http://" + url;
            homePagePicture.setUrl(url);
        }
        return homePagePictureService.addHomePagePicture(homePagePicture);
    }
    public @ResponseBody @RequestMapping("deleteHomePagePicture") boolean deleteHomePagePicture(int homePagePictureID) {
        return homePagePictureService.deleteHomePagePicture(homePagePictureID);
    }
    public @ResponseBody @RequestMapping("getHomePagePictureByID") HomePagePicture getHomePagePictureByID(int homePagePictureID) {
        return homePagePictureService.getHomePagePictureByID(homePagePictureID);
    }
    public @ResponseBody @RequestMapping("getAllHomePagePictures") List<HomePagePicture> getAllHomePagePictures() {
        return homePagePictureService.getAllHomePagePictures();
    }
    public @ResponseBody @RequestMapping("getAllHomePagePicturesDeal") Map getAllHomePagePicturesDeal() {
        Map result = new HashMap();
        List<HomePagePicture> datas;
        try {
            datas = homePagePictureService.getAllHomePagePictures();
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
    public @ResponseBody @RequestMapping("updateHomePagePicture") boolean updateHomePagePicture(HomePagePicture homePagePicture) {
        if(homePagePicture.getUrl().equals("")) {
            homePagePicture.setUrl(null);
        }
        String url = homePagePicture.getUrl();
        if(url!=null&&!url.startsWith("https://")&&!url.startsWith("http://")) {
            url = "http://" + url;
            homePagePicture.setUrl(url);
        }
        return homePagePictureService.updateHomePagePicture(homePagePicture);
    }
}
