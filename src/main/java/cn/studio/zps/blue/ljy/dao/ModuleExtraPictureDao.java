package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.ModuleExtraPicture;

import java.util.List;

public interface ModuleExtraPictureDao {
    int addModuleExtraPicture(ModuleExtraPicture moduleExtraPicture);
    int deleteModuleExtraPicture(int id);
    Long count(int moduleID);
    ModuleExtraPicture getModuleExtraPictureByID(int id);
    List<ModuleExtraPicture> getModuleExtraPicturesByModuleExtraID(int moduleID);
    List<ModuleExtraPicture> getAllModuleExtraPictures();
    int updateModuleExtraPicture(ModuleExtraPicture moduleExtraPicture);
}
