package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.ModulePictureDao;
import cn.studio.zps.blue.ljy.domain.ModulePicture;
import cn.studio.zps.blue.ljy.service.ModulePictureService;
import cn.studio.zps.blue.ljy.utils.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public @Service class ModulePictureServiceImpl implements ModulePictureService {
    private @Autowired
    ModulePictureDao modulePictureDao;
    private static final int MAX_NUMBER = 3;
    @Override
    public Map addModulePicture(ModulePicture modulePicture) {
        Map result = new HashMap();
        long number = modulePictureDao.count(modulePicture.getModuleID());
        if (number >= MAX_NUMBER) {
            result.put("code",false);
            result.put("msg","图片超过了限度");
            return result;
        }
        if(modulePictureDao.addModulePicture(modulePicture) > 0) {
            result.put("code",true);
            result.put("msg",null);
        } else {
            result.put("code",false);
            result.put("msg","服务器出错");
        }
        return result;
    }

    @Override
    public boolean deleteModulePicture(int id) {
        ModulePicture modulePicture = modulePictureDao.getModulePictureByID(id);
        FileUpload.deleteModulePicture(modulePicture.getPath());
        return modulePictureDao.deleteModulePicture(id) > 0;
    }

    @Override
    public ModulePicture getModulePictureByID(int modulePictureID) {
        return modulePictureDao.getModulePictureByID(modulePictureID);
    }

    @Override
    public List<ModulePicture> getModulePicturesByModuleID(int moduleID) {
        return modulePictureDao.getModulePicturesByModuleID(moduleID);
    }

    @Override
    public List<ModulePicture> getAllModulePictures() {
        return modulePictureDao.getAllModulePictures();
    }

    @Override
    public boolean updateModulePicture(ModulePicture modulePicture) {
        ModulePicture origin = modulePictureDao.getModulePictureByID(modulePicture.getId());
        if (!origin.getPath().equals(modulePicture.getPath())) {
            FileUpload.deleteModulePicture(origin.getPath());
        }
        return modulePictureDao.updateModulePicture(modulePicture) > 0;
    }
}
