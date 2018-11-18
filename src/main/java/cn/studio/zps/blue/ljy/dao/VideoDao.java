package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Video;

import java.util.List;

public interface VideoDao {
    Video getVideo(int videoID);
    List<Video> getVideosByCourseID(int courseID);
}
