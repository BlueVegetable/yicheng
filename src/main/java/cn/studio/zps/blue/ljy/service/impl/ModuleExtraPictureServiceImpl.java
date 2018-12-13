package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.ModuleExtraPictureDao;
import cn.studio.zps.blue.ljy.domain.ModuleExtraPicture;
import cn.studio.zps.blue.ljy.service.ModuleExtraPictureService;
import cn.studio.zps.blue.ljy.utils.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public @Service class ModuleExtraPictureServiceImpl implements ModuleExtraPictureService {
    private @Autowired
    ModuleExtraPictureDao moduleExtraPictureDao;
    private static final int MAX_NUMBER = 3;
    @Override
    public Map addModuleExtraPicture(ModuleExtraPicture moduleExtraPicture) {
        Map result = new HashMap();
        long number = moduleExtraPictureDao.count(moduleExtraPicture.getModuleId());
        if (number >= MAX_NUMBER) {
            result.put("code",false);
            result.put("msg","图片超过了限度");
            return result;
        }
        if(moduleExtraPictureDao.addModuleExtraPicture(moduleExtraPicture) > 0) {
            result.put("code",true);
            result.put("msg",null);
        } else {
            result.put("code",false);
            result.put("msg","服务器出错");
        }
        return result;
    }

    @Override
    public boolean deleteModuleExtraPicture(int id) {
        ModuleExtraPicture moduleExtraPicture = moduleExtraPictureDao.getModuleExtraPictureByID(id);
        FileUpload.deleteModuleExtraPicture(moduleExtraPicture.getPath());
        return moduleExtraPictureDao.deleteModuleExtraPicture(id) > 0;
    }

    @Override
    public ModuleExtraPicture getModuleExtraPictureByID(int moduleExtraPictureID) {
        return moduleExtraPictureDao.getModuleExtraPictureByID(moduleExtraPictureID);
    }

    @Override
    public List<ModuleExtraPicture> getModuleExtraPicturesByModuleID(int moduleID) {
        return moduleExtraPictureDao.getModuleExtraPicturesByModuleID(moduleID);
    }

    @Override
    public List<ModuleExtraPicture> getAllModuleExtraPictures() {
        return moduleExtraPictureDao.getAllModuleExtraPictures();
    }

    @Override
    public boolean updateModuleExtraPicture(ModuleExtraPicture moduleExtraPicture) {
        ModuleExtraPicture origin = moduleExtraPictureDao.getModuleExtraPictureByID(moduleExtraPicture.getId());
        if (!origin.getPath().equals(moduleExtraPicture.getPath())) {
            FileUpload.deleteModuleExtraPicture(origin.getPath());
        }
        return moduleExtraPictureDao.updateModuleExtraPicture(moduleExtraPicture) > 0;
    }
}
