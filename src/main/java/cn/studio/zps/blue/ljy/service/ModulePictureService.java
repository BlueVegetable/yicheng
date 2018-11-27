package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.ModulePicture;

import java.util.List;
import java.util.Map;

public interface ModulePictureService {
    Map addModulePicture(ModulePicture modulePicture);
    boolean deleteModulePicture(int id);
    ModulePicture getModulePictureByID(int modulePictureID);
    List<ModulePicture> getModulePicturesByModuleID(int moduleID);
    List<ModulePicture> getAllModulePictures();
    boolean updateModulePicture(ModulePicture modulePicture);
}
