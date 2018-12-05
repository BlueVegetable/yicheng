package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.ModuleExtraPicture;

import java.util.List;
import java.util.Map;

public interface ModuleExtraPictureService {
    Map addModuleExtraPicture(ModuleExtraPicture moduleExtraPicture);
    boolean deleteModuleExtraPicture(int id);
    ModuleExtraPicture getModuleExtraPictureByID(int moduleExtraPictureID);
    List<ModuleExtraPicture> getModuleExtraPicturesByModuleExtraID(int moduleExtraID);
    List<ModuleExtraPicture> getAllModuleExtraPictures();
    boolean updateModuleExtraPicture(ModuleExtraPicture moduleExtraPicture);
}
