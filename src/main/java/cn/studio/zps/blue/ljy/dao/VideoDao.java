package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoDao {
    int addVideo(Video video);
    int deleteVideo(int videoID);
    Video getVideo(int videoID);
    List<Video> getVideosByCourseID(int courseID);
    List<Video> getVideos(@Param("courseID")Integer courseID,@Param("start")Integer start,@Param("number")Integer number);
    Long getVideosNumber(@Param("courseID")Integer courseID);
    int updateVideo(Video video);
}
