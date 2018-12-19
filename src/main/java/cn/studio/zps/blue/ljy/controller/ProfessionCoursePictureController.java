package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.ProfessionCoursePicture;
import cn.studio.zps.blue.ljy.service.ProfessionCoursePictureService;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("professionCoursePicture")
public class ProfessionCoursePictureController{

	@Autowired
	private ProfessionCoursePictureService professionCoursePictureService;

	@ResponseBody
	@RequestMapping("addprofessionCoursePicture")
	public Map<String,Object> addProfessionCoursePicture(ProfessionCoursePicture professionCoursePicture) {
		if(professionCoursePictureService.addProfessionCoursePicture(professionCoursePicture))
			return Response.getResponseMap(0,"添加成功",null);
		else
			return Response.getResponseMap(1,"添加失败",null);
	}

	@ResponseBody@RequestMapping("deleteprofessionCoursePicture")
	public Map<String,Object> deleteProfessionCoursePicture(@RequestParam("professionCoursePictureID")int professionCoursePictureID) {
		if(professionCoursePictureService.deleteProfessionCoursePicture(professionCoursePictureID)) {
			return Response.getResponseMap(0,"修改成功",null);
		}
		else {
			return Response.getResponseMap(1,"修改失败",null);
		}
	}

	@ResponseBody@RequestMapping("getProfessionCoursePictureByID")
	public ProfessionCoursePicture getProfessionCoursePictureByID(int professionCoursePictureID) {
		return professionCoursePictureService.getProfessionCoursePictureByID(professionCoursePictureID);
	}

	@ResponseBody@RequestMapping("getProfessionCoursePictures")
	public List<ProfessionCoursePicture> getProfessionCoursePictures() {
		return professionCoursePictureService.getProfessionCoursePictures(null,null);
	}

	@ResponseBody@RequestMapping("getProfessionCoursePicturesDeal")
	public Map<String,Object> getProfessionCoursePicturesDeal(@RequestParam(value = "id",required=false)int id,@RequestParam(value = "path",required=false)String path,@RequestParam(value = "url",required=false)String url) {
		return Response.getResponseMap(0,"",professionCoursePictureService.getProfessionCoursePictures(path,url));
	}

	@ResponseBody@RequestMapping("updateProfessionCoursePicture")
	public Map<String,Object> updateProfessionCoursePicture(ProfessionCoursePicture professionCoursePicture) {
		if(professionCoursePictureService.updateProfessionCoursePicture(professionCoursePicture)) {
			return Response.getResponseMap(0,"",null);
		} else {
			return Response.getResponseMap(1,"",null);
		}
	}

}