package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.ModuleNavigation;
import cn.studio.zps.blue.ljy.service.ModuleNavigationService;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.List;

@Controller@RequestMapping("moduleNavigation")
public class ModuleNavigationController{

	@Autowired
	private ModuleNavigationService moduleNavigationService;

	@ResponseBody
	@RequestMapping("addModuleNavigation")
	public Map<String,Object> addModuleNavigation(ModuleNavigation moduleNavigation) {
		if(moduleNavigationService.addModuleNavigation(moduleNavigation))
			return Response.getResponseMap(0,"添加成功",null);
		else
			return Response.getResponseMap(1,"添加失败",null);
	}

	@ResponseBody@RequestMapping("deletemoduleNavigation")
	public Map<String,Object> deleteModuleNavigation(@RequestParam("moduleNavigationID")int moduleNavigationID) {
		if(moduleNavigationService.deleteModuleNavigationByID(moduleNavigationID)) {
			return Response.getResponseMap(0,"修改成功",null);
		}
		else {
			return Response.getResponseMap(1,"修改失败",null);
		}
	}

	@ResponseBody@RequestMapping("getModuleNavigationByID")
	public ModuleNavigation getModuleNavigationByID(int moduleNavigationID) {
		return moduleNavigationService.getModuleNavigationByID(moduleNavigationID);
	}

	@ResponseBody@RequestMapping("getModuleNavigations")
	public List<ModuleNavigation> getModuleNavigations() {
		return moduleNavigationService.getModuleNavigations(null,null,null);
	}

	@ResponseBody@RequestMapping("getModuleNavigationsDeal")
	public Map<String,Object> getModuleNavigationsDeal(@RequestParam(value = "name",required=false)String name,@RequestParam(value = "url",required=false)String url,@RequestParam(value = "moduleID",required=false)Integer moduleID) {
		return Response.getResponseMap(0,"",moduleNavigationService.getModuleNavigations(name,url,moduleID));
	}

	@ResponseBody@RequestMapping("updateModuleNavigation")
	public Map<String,Object> updateModuleNavigation(ModuleNavigation moduleNavigation) {
		if(moduleNavigationService.updateModuleNavigation(moduleNavigation)) {
			return Response.getResponseMap(0,"",null);
		} else {
			return Response.getResponseMap(1,"",null);
		}
	}

}