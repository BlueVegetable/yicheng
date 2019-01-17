package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.Video;
import cn.studio.zps.blue.ljy.service.VideoService;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller@RequestMapping("video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @ResponseBody@RequestMapping("addVideo")
    public Map addVideo(Video video) {
        String url = video.getUrl();
        if(!url.startsWith("http://")&&!url.startsWith("https://")) {
            video.setUrl("http://" + url);
        }
        if(videoService.addVideo(video)) {
            return Response.getResponseMap(0,"",null);
        } else {
            return Response.getResponseMap(1,"添加失败",null);
        }
    }
    @ResponseBody@RequestMapping("deleteVideo")
    public Map deleteVideo(int videoID) {
        if(videoService.deleteVideo(videoID)) {
            return Response.getResponseMap(0,"",null);
        } else {
            return Response.getResponseMap(1,"删除失败",null);
        }
    }
    @ResponseBody@RequestMapping("getVideosByCourseIDWithIntroduce")
    public List<Video> getVideosByCourseIDWithIntroduce(int courseID) {
        return videoService.getVideosByCourseIDWithIntroduce(courseID);
    }
    @ResponseBody@RequestMapping("getVideosDeal")
    public Map getVideosDeal(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit,
                             @RequestParam(value = "courseID",required = false)Integer courseID) {
        List<Video> videos = videoService.getVideos(courseID,page,limit);
        Map result = new HashMap();
        result.put("data",videos);
        result.put("count",videoService.getVideosNumber(courseID));
        result.put("code",0);
        result.put("msg","");
        return result;
    }
    @ResponseBody@RequestMapping("updateVideo")
    public Map updateVideo(Video video) {
        String url = video.getUrl();
        if(!url.startsWith("http://")&&!url.startsWith("https://")) {
            video.setUrl("http://" + url);
        }
        if(videoService.updateVideo(video)) {
            return Response.getResponseMap(0,"",null);
        } else {
            return Response.getResponseMap(1,"未作出修改",null);
        }
    }
}
