package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.ModuleDao;
import cn.studio.zps.blue.ljy.domain.Module;
import cn.studio.zps.blue.ljy.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public @Service
class ModuleServiceImpl implements ModuleService {
    private @Autowired ModuleDao moduleDao;

    @Override
    public boolean addModule(Module module) {
        return moduleDao.addModule(module)>0;
    }

    @Override
    public boolean deleteModule(int moduleID) {
        return moduleDao.deleteModule(moduleID)>0;
    }

    @Override
    public Module getModuleByID(int moduleID) {
        return moduleDao.getModuleByID(moduleID);
    }

    @Override
    public Module getModuleByTypeID(int typeID) {
        return moduleDao.getModuleByTypeID(typeID);
    }

    @Override
    public List<Module> getAllModules() {
        return moduleDao.getAllModules();
    }
}
