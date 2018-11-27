package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.ModulePicture;
import cn.studio.zps.blue.ljy.service.ModulePictureService;
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

public @Controller @RequestMapping("modulePicture") class ModulePictureController {
    private @Autowired ModulePictureService modulePictureService;
    private static final String DIRECTORY="/modulePicture";
    public @ResponseBody @RequestMapping("uploadModulePicture") Map uploadModulePicture(MultipartFile file){
        Map<String,Object> value = FileUpload.copyModulePicture(file);
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
    public @ResponseBody @RequestMapping("addModulePicture") Map addModulePicture(ModulePicture modulePicture) {
        return modulePictureService.addModulePicture(modulePicture);
    }
    public @ResponseBody @RequestMapping("deleteModulePicture") boolean deleteModulePicture(int modulePictureID) {
        return modulePictureService.deleteModulePicture(modulePictureID);
    }
    public @ResponseBody @RequestMapping("getModulePictureByID") ModulePicture getModulePictureByID(int modulePictureID) {
        return modulePictureService.getModulePictureByID(modulePictureID);
    }
    public @ResponseBody @RequestMapping("getModulePicturesByModuleID") List<ModulePicture> getModulePicturesByModuleID(int moduleID) {
        return modulePictureService.getModulePicturesByModuleID(moduleID);
    }
    public @ResponseBody @RequestMapping("getAllModulePicturesDeal") Map getAllModulePicturesDeal() {
        Map result = new HashMap();
        List<ModulePicture> datas;
        try {
            datas = modulePictureService.getAllModulePictures();
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
    public @ResponseBody @RequestMapping("updateModulePicture") boolean updateModulePicture(ModulePicture modulePicture) {
        return modulePictureService.updateModulePicture(modulePicture);
    }
}