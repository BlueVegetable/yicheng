package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.ModuleNavigation;

import java.util.List;

public interface ModuleNavigationService {

	boolean addModuleNavigation(ModuleNavigation moduleNavigation);

	boolean deleteModuleNavigationByID(int moduleNavigationID);

	ModuleNavigation getModuleNavigationByID(int moduleNavigationID);

	List<ModuleNavigation> getModuleNavigations(Integer moduleID,Integer page,Integer number);

	Long countModuleNavigations(Integer moduleID);

	boolean updateModuleNavigation(ModuleNavigation moduleNavigation);

}