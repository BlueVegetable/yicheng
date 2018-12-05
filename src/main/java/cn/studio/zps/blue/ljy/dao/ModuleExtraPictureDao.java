package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.ModuleExtraPicture;

import java.util.List;

public interface ModuleExtraPictureDao {
    int addModuleExtraPicture(ModuleExtraPicture moduleExtraPicture);
    int deleteModuleExtraPicture(int id);
    Long count(int moduleExtraID);
    ModuleExtraPicture getModuleExtraPictureByID(int id);
    List<ModuleExtraPicture> getModuleExtraPicturesByModuleExtraID(int moduleExtraID);
    List<ModuleExtraPicture> getAllModuleExtraPictures();
    int updateModuleExtraPicture(ModuleExtraPicture moduleExtraPicture);
}
