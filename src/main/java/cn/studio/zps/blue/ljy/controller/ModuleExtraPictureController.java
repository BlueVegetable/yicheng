package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.ModuleExtraPicture;
import cn.studio.zps.blue.ljy.service.ModuleExtraPictureService;
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

public @Controller @RequestMapping("moduleExtraPicture") class ModuleExtraPictureController {
    private @Autowired ModuleExtraPictureService moduleExtraPictureService;
    private static final String DIRECTORY="/moduleExtraPicture";
    public @ResponseBody @RequestMapping("uploadModuleExtraPicture") Map uploadModuleExtraPicture(MultipartFile file){
        Map<String,Object> value = FileUpload.copyModuleExtraPicture(file);
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
    public @ResponseBody @RequestMapping("addModuleExtraPicture") Map addModuleExtraPicture(ModuleExtraPicture moduleExtraPicture) {
        if(moduleExtraPicture.getUrl().equals("")) {
            moduleExtraPicture.setUrl(null);
        }
        String url = moduleExtraPicture.getUrl();
        if(url!=null&&!url.startsWith("https://")&&!url.startsWith("http://")) {
            url = "http://" + url;
            moduleExtraPicture.setUrl(url);
        }
        return moduleExtraPictureService.addModuleExtraPicture(moduleExtraPicture);
    }
    public @ResponseBody @RequestMapping("deleteModuleExtraPicture") boolean deleteModuleExtraPicture(int moduleExtraPictureID) {
        return moduleExtraPictureService.deleteModuleExtraPicture(moduleExtraPictureID);
    }
    public @ResponseBody @RequestMapping("getModuleExtraPictureByID") ModuleExtraPicture getModuleExtraPictureByID(int moduleExtraPictureID) {
        return moduleExtraPictureService.getModuleExtraPictureByID(moduleExtraPictureID);
    }
    public @ResponseBody @RequestMapping("getModuleExtraPicturesByModuleExtraID") List<ModuleExtraPicture> getModuleExtraPicturesByModuleExtraID(int moduleID) {
        return moduleExtraPictureService.getModuleExtraPicturesByModuleID(moduleID);
    }
    public @ResponseBody @RequestMapping("getAllModuleExtraPicturesDeal") Map getAllModuleExtraPicturesDeal() {
        Map result = new HashMap();
        List<ModuleExtraPicture> datas;
        try {
            datas = moduleExtraPictureService.getAllModuleExtraPictures();
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
    public @ResponseBody @RequestMapping("updateModuleExtraPicture") boolean updateModuleExtraPicture(ModuleExtraPicture moduleExtraPicture) {
        if(moduleExtraPicture.getUrl().equals("")) {
            moduleExtraPicture.setUrl(null);
        }
        String url = moduleExtraPicture.getUrl();
        if(url!=null&&!url.startsWith("https://")&&!url.startsWith("http://")) {
            url = "http://" + url;
            moduleExtraPicture.setUrl(url);
        }
        return moduleExtraPictureService.updateModuleExtraPicture(moduleExtraPicture);
    }
}