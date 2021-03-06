package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Module;

import java.util.List;

public interface ModuleDao {
    int addModule(Module module);
    int deleteModule(int moduleID);
    Module getModuleByID(int moduleID);
    Module getModuleByTypeID(int typeID);
    List<Module> getAllModules();
    int updateModule(Module module);
}
