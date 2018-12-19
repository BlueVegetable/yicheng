package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.ProfessionCoursePicture;
import cn.studio.zps.blue.ljy.service.ProfessionCoursePictureService;
import cn.studio.zps.blue.ljy.utils.FileUpload;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller@RequestMapping("professionCoursePicture")
public class ProfessionCoursePictureController{

	@Autowired
	private ProfessionCoursePictureService professionCoursePictureService;
	private static final String DIRECTORY="/professionCoursePicture";

	@ResponseBody @RequestMapping("uploadProfessionCoursePicture")
	public Map uploadProfessionCoursePicture(MultipartFile file){
		Map<String,Object> value = FileUpload.copyProfessionCoursePicture(file);
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

	@ResponseBody @RequestMapping("addProfessionCoursePicture")
	public Map<String,Object> addProfessionCoursePicture(ProfessionCoursePicture professionCoursePicture) {
		if(professionCoursePictureService.addProfessionCoursePicture(professionCoursePicture))
			return Response.getResponseMap(0,"添加成功",null);
		else
			return Response.getResponseMap(1,"添加失败",null);
	}

	@ResponseBody@RequestMapping("deleteProfessionCoursePicture")
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
	public Map<String,Object> getProfessionCoursePicturesDeal(@RequestParam(value = "path",required=false)String path,@RequestParam(value = "url",required=false)String url) {
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