package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.ModuleNavigationDao;
import cn.studio.zps.blue.ljy.domain.ModuleNavigation;
import cn.studio.zps.blue.ljy.service.ModuleNavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleNavigationServiceImpl implements ModuleNavigationService {

	@Autowired
	private ModuleNavigationDao moduleNavigationDao;

	@Override
	public boolean addModuleNavigation(ModuleNavigation moduleNavigation) {
		return moduleNavigationDao.addModuleNavigation(moduleNavigation)>0;
	}

	@Override
	public boolean deleteModuleNavigationByID(int moduleNavigationID) {
		return moduleNavigationDao.deleteModuleNavigationByID(moduleNavigationID)>0;
	}

	@Override
	public ModuleNavigation getModuleNavigationByID(int moduleNavigationID) {
		return moduleNavigationDao.getModuleNavigationByID(moduleNavigationID);
	}

	@Override
	public List<ModuleNavigation> getModuleNavigations(String name,String url,Integer moduleID) {
		return moduleNavigationDao.getModuleNavigations(name,url,moduleID);
	}

	@Override
	public boolean updateModuleNavigation(ModuleNavigation moduleNavigation) {
		return moduleNavigationDao.updateModuleNavigation(moduleNavigation)>0;
	}

}