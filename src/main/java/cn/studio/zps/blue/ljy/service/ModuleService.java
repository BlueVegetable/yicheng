package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.Module;

import java.util.List;

public interface ModuleService {
    boolean addModule(Module module);
    boolean deleteModule(int moduleID);
    List<Module> getAllModules();
}
