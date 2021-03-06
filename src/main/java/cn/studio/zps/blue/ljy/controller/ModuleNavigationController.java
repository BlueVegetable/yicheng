package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.Module;
import cn.studio.zps.blue.ljy.domain.ModuleNavigation;
import cn.studio.zps.blue.ljy.service.ModuleNavigationService;
import cn.studio.zps.blue.ljy.service.ModuleService;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller@RequestMapping("moduleNavigation")
public class ModuleNavigationController{

	@Autowired
	private ModuleService moduleService;

	@Autowired
	private ModuleNavigationService moduleNavigationService;

	@ResponseBody
	@RequestMapping("addModuleNavigation")
	public Map<String,Object> addModuleNavigation(ModuleNavigation moduleNavigation) {
		if(moduleNavigation.getUrl().equals(""))
			moduleNavigation.setUrl(null);
		String url = moduleNavigation.getUrl();
		if(url!=null&&!url.startsWith("https://")&&!url.startsWith("http://")) {
			moduleNavigation.setUrl("http://"+url);
		}
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
	public List<ModuleNavigation> getModuleNavigations(@RequestParam(value = "moduleID",required = false)Integer moduleID) {
		return moduleNavigationService.getModuleNavigations(null,null,moduleID);
	}

	@ResponseBody@RequestMapping("getAllModuleNavigationsInfo")
	public Map<String,Object> getAllModuleNavigationsInfo() {
		List<Module> modules = moduleService.getAllModules();
		Map<String,Object> result = new LinkedHashMap<>();
		List<List<ModuleNavigation>> moduleNavigationsList = new ArrayList<>();
		result.put("modules",modules);
		for (Module module:modules) {
			List<ModuleNavigation> moduleNavigations = moduleNavigationService.getModuleNavigations(null,null,module.getId());
			moduleNavigationsList.add(moduleNavigations);
		}
		result.put("moduleNavigation",moduleNavigationsList);
		return result;
	}

	@ResponseBody@RequestMapping("getModuleNavigationsDeal")
	public Map<String,Object> getModuleNavigationsDeal(@RequestParam(value = "page",required=false)Integer page,
													   @RequestParam(value = "limit",required=false)Integer number,
													   @RequestParam(value = "moduleID",required=false)Integer moduleID) {
		Map result = Response.getResponseMap(0,"",moduleNavigationService.getModuleNavigations(moduleID,page,number));
		result.put("count",moduleNavigationService.countModuleNavigations(moduleID));
		return result;
	}

	@ResponseBody@RequestMapping("updateModuleNavigation")
	public Map<String,Object> updateModuleNavigation(ModuleNavigation moduleNavigation) {
		if(moduleNavigation.getUrl().equals(""))
			moduleNavigation.setUrl(null);
		String url = moduleNavigation.getUrl();
		if(url!=null&&!url.startsWith("https://")&&!url.startsWith("http://")) {
			moduleNavigation.setUrl("http://"+url);
		}
		if(moduleNavigationService.updateModuleNavigation(moduleNavigation)) {
			return Response.getResponseMap(0,"",null);
		} else {
			return Response.getResponseMap(1,"",null);
		}
	}

}