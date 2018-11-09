package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.Module;
import cn.studio.zps.blue.ljy.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("module")
public @Controller class ModuleController {
    private @Autowired ModuleService moduleService;
    @RequestMapping("addModule")
    public @ResponseBody boolean addModule(Module module) {
        return moduleService.addModule(module);
    }
    @RequestMapping("deleteModule")
    public @ResponseBody boolean deleteModule(int moduleID) {
        return moduleService.deleteModule(moduleID);
    }
    @RequestMapping("getAllModules")
    public @ResponseBody List<Module> getAllModules() {
        return moduleService.getAllModules();
    }
}
