package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.Video;

import java.util.List;

public interface VideoService {
    boolean addVideo(Video video);
    boolean deleteVideo(int videoID);
    Video getVideoByID(int videoID);
    List<Video> getVideos(Integer courseID,Integer page,Integer number);
    Long getVideosNumber(Integer courseID);
    boolean updateVideo(Video video);
}
