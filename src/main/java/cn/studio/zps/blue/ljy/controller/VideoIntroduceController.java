import java.util.Map;
import java.util.List;

@Controller@RequestMapping("videoIntroduce")
public class VideoIntroduceController{

	@Autowired
	private VideoIntroduceService videoIntroduceService;

	@ResponseBody@RequestMapping("addVideoIntroduce")
	public Map<String,Object> addVideoIntroduce(VideoIntroduce videoIntroduce) {
		if(videoIntroduceService.addVideoIntroduce(videoIntroduce))
			return Response.getResponseMap(0,"添加成功",null);
		else
			return Response.getResponseMap(1,"添加失败",null);
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

	@ResponseBody@RequestMapping("getVideoIntroduceByID")
	public VideoIntroduce getVideoIntroduceByID(int videoIntroduceID) {
		return videoIntroduceService.getVideoIntroduceByID(videoIntroduceID);
	}

	@ResponseBody@RequestMapping("getVideoIntroduces")
	public List<VideoIntroduce> getVideoIntroduces() {
		return videoIntroduceService.getVideoIntroduces(null,null,null);
	}

	@ResponseBody@RequestMapping("getVideoIntroducesDeal")
	public Map<String,Object> getVideoIntroducesDeal(@RequestParam(value = "id",required=false)int id,@RequestParam(value = "content",required=false)String content,@RequestParam(value = "articleID",required=false)int articleID) {
		return Response.getResponseMap(0,"",videoIntroduceService.getVideoIntroduces(id,content,articleID));
	}

	@ResponseBody@RequestMapping("updateVideoIntroduce")
	public Map<String,Object> updateVideoIntroduce(VideoIntroduce videoIntroduce) {
		if(videoIntroduceService.updateVideoIntroduce(videoIntroduce)) {
			return Response.getResponseMap(0,"",null);
		} else {
			return Response.getResponseMap(1,"",null);
		}
	}

}