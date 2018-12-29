package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.HomePageBanner;
import cn.studio.zps.blue.ljy.service.HomePageBannerService;
import cn.studio.zps.blue.ljy.utils.FileUpload;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Controller @RequestMapping("homePageBanner")
public class HomePageBannerController{

	@Autowired
	private HomePageBannerService homePageBannerService;

	private static final String DIRECTORY="/homePageBanner";

	public @ResponseBody @RequestMapping("uploadHomePageBanner") Map uploadHomePagePicture(MultipartFile file){
		Map<String,Object> value = FileUpload.copyHomePagePicture(file);
		String name = (String) value.get("fileName");
		String msg = value.get("code").equals("SUCCESS")?"":"上传失败";
		int code = value.get("code").equals("SUCCESS")?0:1;

		Map<String,Object> data = new HashMap<>(2);
		data.put("path",DIRECTORY+"/"+name);
		data.put("type", value.get("fileType"));

		Map<String,Object> result = new HashMap<>(3);
		result.put("code",code);
		result.put("msg",msg);
		result.put("data",data);
		return result;
	}

	@ResponseBody
	@RequestMapping("addHomePageBanner")
	public Map<String,Object> addHomePageBanner(HomePageBanner homePageBanner) {
		if(homePageBannerService.addHomePageBanner(homePageBanner))
			return Response.getResponseMap(0,"添加成功",null);
		else
			return Response.getResponseMap(1,"添加失败",null);
	}

	@ResponseBody@RequestMapping("deletehomePageBanner")
	public Map<String,Object> deleteHomePageBanner(@RequestParam("homePageBannerID")int homePageBannerID) {
		if(homePageBannerService.deleteHomePageBannerByID(homePageBannerID)) {
			return Response.getResponseMap(0,"修改成功",null);
		}
		else {
			return Response.getResponseMap(1,"修改失败",null);
		}
	}

	@ResponseBody@RequestMapping("getHomePageBannerByID")
	public HomePageBanner getHomePageBannerByID(int homePageBannerID) {
		return homePageBannerService.getHomePageBannerByID(homePageBannerID);
	}

	@ResponseBody@RequestMapping("getHomePageBanners")
	public List<HomePageBanner> getHomePageBanners() {
		return homePageBannerService.getHomePageBanners(null,null);
	}

	@ResponseBody@RequestMapping("getHomePageBannersDeal")
	public Map<String,Object> getHomePageBannersDeal(@RequestParam(value = "image",required=false)String image,@RequestParam(value = "url",required=false)String url) {
		return Response.getResponseMap(0,"",homePageBannerService.getHomePageBanners(image,url));
	}

	@ResponseBody@RequestMapping("updateHomePageBanner")
	public Map<String,Object> updateHomePageBanner(HomePageBanner homePageBanner) {
		if(homePageBannerService.updateHomePageBanner(homePageBanner)) {
			return Response.getResponseMap(0,"",null);
		} else {
			return Response.getResponseMap(1,"",null);
		}
	}

}