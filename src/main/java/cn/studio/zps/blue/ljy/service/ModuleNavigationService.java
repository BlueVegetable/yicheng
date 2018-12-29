package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.ModuleNavigation;

import java.util.List;

public interface ModuleNavigationService {

	boolean addModuleNavigation(ModuleNavigation moduleNavigation);

	boolean deleteModuleNavigationByID(int moduleNavigationID);

	ModuleNavigation getModuleNavigationByID(int moduleNavigationID);

	List<ModuleNavigation> getModuleNavigations(String name, String url,Integer moduleID);

	boolean updateModuleNavigation(ModuleNavigation moduleNavigation);

}