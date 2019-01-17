package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.VideoIntroduce;
import cn.studio.zps.blue.ljy.service.VideoIntroduceService;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.List;

@Controller
@RequestMapping("videoIntroduce")
public class VideoIntroduceController{

	@Autowired
	private VideoIntroduceService videoIntroduceService;

	@ResponseBody @RequestMapping("addVideoIntroduce")
	public Map<String,Object> addVideoIntroduce(@RequestBody VideoIntroduce videoIntroduce) {
		return videoIntroduceService.addVideoIntroduce(videoIntroduce);
	}

	@ResponseBody@RequestMapping("deletevideoIntroduce")
	public Map<String,Object> deleteVideoIntroduce(@RequestParam("videoIntroduceID")int videoIntroduceID) {
		if(videoIntroduceService.deleteVideoIntroduceByID(videoIntroduceID)) {
			return Response.getResponseMap(0,"修改成功",null);
		}
		else {
			return Response.getResponseMap(1,"修改失败",null);
		}
	}

	@ResponseBody@RequestMapping("getVideoIntroduceByVideoID")
	public Map getVideoIntroduceByVideoID(int videoID) {
		VideoIntroduce videoIntroduce = videoIntroduceService.getVideoIntroduceByVideoID(videoID);
		if(videoIntroduce!=null) {
			return Response.getResponseMap(0,"",videoIntroduce);
		} else {
			return Response.getResponseMap(1,"不存在",null);
		}
	}

	@ResponseBody@RequestMapping("getVideoIntroduceContentByVideoID")
	public Map getVideoIntroduceContentByVideoID(@RequestParam("videoID") int videoID) {
		VideoIntroduce videoIntroduce = videoIntroduceService.getVideoIntroduceContentByVideoID(videoID);
		if(videoIntroduce!=null) {
			return Response.getResponseMap(0,"",videoIntroduce);
		} else {
			return Response.getResponseMap(1,"数据不存在",null);
		}
	}

	@ResponseBody@RequestMapping("getVideoIntroduceByID")
	public VideoIntroduce getVideoIntroduceByID(int videoIntroduceID) {
		return videoIntroduceService.getVideoIntroduceByID(videoIntroduceID);
	}

	@ResponseBody@RequestMapping("getVideoIntroduces")
	public List<VideoIntroduce> getVideoIntroduces() {
		return videoIntroduceService.getVideoIntroduces(null,null,null);
	}

	@ResponseBody@RequestMapping("getVideoIntroducesDeal")
	public Map<String,Object> getVideoIntroducesDeal(@RequestParam(value = "title",required=false)String title,
													 @RequestParam(value = "content",required=false)String content,
													 @RequestParam(value = "videoID",required=false)Integer videoID) {
		return Response.getResponseMap(0,"",videoIntroduceService.getVideoIntroduces(title,content,videoID));
	}

	@ResponseBody@RequestMapping("updateVideoIntroduce")
	public Map<String,Object> updateVideoIntroduce(@RequestBody VideoIntroduce videoIntroduce) {
		if(videoIntroduceService.updateVideoIntroduce(videoIntroduce)) {
			return Response.getResponseMap(0,"",null);
		} else {
			return Response.getResponseMap(1,"",null);
		}
	}

}