package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.ModuleNavigation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModuleNavigationDao {

	int addModuleNavigation(ModuleNavigation moduleNavigation);

	int deleteModuleNavigationByID(int moduleNavigationID);

	ModuleNavigation getModuleNavigationByID(int moduleNavigationID);

	List<ModuleNavigation> getModuleNavigations(@Param("name") String name, @Param("url") String url, @Param("moduleID") Integer moduleID);

	int updateModuleNavigation(ModuleNavigation moduleNavigation);

}