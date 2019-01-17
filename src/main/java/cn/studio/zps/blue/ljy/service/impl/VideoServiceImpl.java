package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.VideoDao;
import cn.studio.zps.blue.ljy.domain.Video;
import cn.studio.zps.blue.ljy.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoDao videoDao;
    @Override
    public boolean addVideo(Video video) {
        return videoDao.addVideo(video) > 0;
    }

    @Override
    public boolean deleteVideo(int videoID) {
        return videoDao.deleteVideo(videoID) > 0;
    }

    @Override
    public Video getVideoByID(int videoID) {
        return videoDao.getVideo(videoID);
    }

    @Override
    public List<Video> getVideos(Integer courseID,Integer page,Integer number) {
        Integer start = null;
        if(page != null) {
            start = (page-1)*number;
        }
        return videoDao.getVideos(courseID,start,number);
    }

    @Override
    public List<Video> getVideosByCourseIDWithIntroduce(int courseID) {
        return videoDao.getVideosByCourseIDWithIntroduce(courseID);
    }

    @Override
    public Long getVideosNumber(Integer courseID) {
        return videoDao.getVideosNumber(courseID);
    }

    @Override
    public boolean updateVideo(Video video) {
        return videoDao.updateVideo(video) > 0;
    }
}
