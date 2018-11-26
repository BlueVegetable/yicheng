package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.ModulePicture;

import java.util.List;

public interface ModulePictureDao {
    int addModulePicture(ModulePicture modulePicture);
    int deleteModulePicture(int id);
    Long count(int moduleID);
    ModulePicture getModulePictureByID(int id);
    List<ModulePicture> getAllModulePictures();
    int updateModulePicture(ModulePicture modulePicture);
}
