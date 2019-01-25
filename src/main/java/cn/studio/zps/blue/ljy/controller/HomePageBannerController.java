package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.HomePageBanner;
import cn.studio.zps.blue.ljy.service.HomePageBannerService;
import cn.studio.zps.blue.ljy.utils.FileUpload;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Controller @RequestMapping("homePageBanner")
public class HomePageBannerController{

	@Autowired
	private HomePageBannerService homePageBannerService;

	private static final String DIRECTORY="/homePageBanner";

	public @ResponseBody @RequestMapping("uploadHomePageBanner") Map uploadHomeBannerPicture(MultipartFile file){
		Map<String,Object> value = FileUpload.copyPicture(file,DIRECTORY);
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

	@ResponseBody@RequestMapping("addHomePageBanner")
	public Map<String,Object> addHomePageBanner(@RequestBody HomePageBanner homePageBanner) {
		if(homePageBanner.getUrl().equals("")) {
			homePageBanner.setUrl(null);
		}
		String url = homePageBanner.getUrl();
		if(url!=null&&!url.startsWith("https://")&&!url.startsWith("http://")) {
			url = "http://" + url;
			homePageBanner.setUrl(url);
		}
		homePageBanner.setPosition(homePageBannerService.getMaxPosition()+1);
		homePageBanner.setVisible((byte)1);
		if(homePageBannerService.addHomePageBanner(homePageBanner))
			return Response.getResponseMap(0,"添加成功",null);
		else
			return Response.getResponseMap(1,"添加失败",null);
	}

	@ResponseBody@RequestMapping("deletehomePageBanner")
	public Map<String,Object> deleteHomePageBanner(@RequestParam("homePageBannerID")int homePageBannerID) {
		if(homePageBannerService.deleteHomePageBannerByID(homePageBannerID)) {
			return Response.getResponseMap(0,"删除成功",null);
		}
		else {
			return Response.getResponseMap(1,"删除失败",null);
		}
	}

	@ResponseBody@RequestMapping("getHomePageBannerByID")
	public HomePageBanner getHomePageBannerByID(int homePageBannerID) {
		return homePageBannerService.getHomePageBannerByID(homePageBannerID);
	}

	@ResponseBody@RequestMapping("getHomePageBanners")
	public List<HomePageBanner> getHomePageBanners() {
		return homePageBannerService.getHomePageBanners(null,null,true);
	}

	@ResponseBody@RequestMapping("getHomePageBannersDeal")
	public Map<String,Object> getHomePageBannersDeal(@RequestParam(value = "image",required=false)String image,@RequestParam(value = "url",required=false)String url) {
		Map<String,Object> result = Response.getResponseMap(0,"",homePageBannerService.getHomePageBanners(image,url,null));
		result.put("number",homePageBannerService.count(image,url,null));
		return result;
	}

	@ResponseBody@RequestMapping("updateHomePageBanner")
	public Map<String,Object> updateHomePageBanner(@RequestBody HomePageBanner homePageBanner) {
		if(homePageBanner.getUrl().equals("")) {
			homePageBanner.setUrl(null);
		}
		String url = homePageBanner.getUrl();
		if(url!=null&&!url.startsWith("https://")&&!url.startsWith("http://")) {
			url = "http://" + url;
			homePageBanner.setUrl(url);
		}
		homePageBanner.setPosition(homePageBannerService.getMaxPosition()+1);
		homePageBanner.setVisible((byte)1);
		if(homePageBannerService.updateHomePageBanner(homePageBanner)) {
			return Response.getResponseMap(0,"",null);
		} else {
			return Response.getResponseMap(1,"修改失败",null);
		}
	}

	@ResponseBody@RequestMapping("/updateState")
	public int updateState(@RequestParam(value="id")int id, @RequestParam("state")int visible) {
		if(homePageBannerService.alterVisible(id,visible==1))
			return 1;
		else
			return 0;
	}

	@ResponseBody@RequestMapping("/upBanner")
	public int upBanner(@RequestParam("id") int current){
		int upId=homePageBannerService.smaller(current);
		if(homePageBannerService.exchange(current,upId)) {
			return 1;
		} else {
			return 0;
		}
	}

	@ResponseBody@RequestMapping("/downBanner")
	public int downBanner(@RequestParam("id")int current){
		int downId=homePageBannerService.bigger(current);
		if(homePageBannerService.exchange(current,downId)) {
			return 1;
		}
		else {
			return 0;
		}
	}

}