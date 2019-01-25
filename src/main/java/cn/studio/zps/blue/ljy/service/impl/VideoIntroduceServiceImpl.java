package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.VideoIntroduceDao;
import cn.studio.zps.blue.ljy.domain.VideoIntroduce;
import cn.studio.zps.blue.ljy.service.VideoIntroduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VideoIntroduceServiceImpl implements VideoIntroduceService {

	@Autowired
	private VideoIntroduceDao videoIntroduceDao;

	@Override
	public Map<String,Object> addVideoIntroduce(VideoIntroduce videoIntroduce) {
		Map<String,Object> result = new HashMap<>();
		if(videoIntroduceDao.count(videoIntroduce.getCourseID())!=0) {
			result.put("code",1);
			result.put("msg","已经存在文章");
			result.put("data",null);
			return result;
		}
		if(videoIntroduceDao.addVideoIntroduce(videoIntroduce) > 0) {
			result.put("code",0);
			result.put("msg","");
			result.put("data",null);
		} else {
			result.put("code",1);
			result.put("msg","添加失败");
			result.put("data",null);
		}
		return result;
	}

	@Override
	public boolean deleteVideoIntroduceByID(int videoIntroduceID) {
		return videoIntroduceDao.deleteVideoIntroduceByID(videoIntroduceID)>0;
	}

	@Override
	public VideoIntroduce getVideoIntroduceByCourseID(int courseID) {
		return videoIntroduceDao.getVideoIntroduceByCourseID(courseID);
	}

	@Override
	public VideoIntroduce getVideoIntroduceContentByCourseID(int courseID) {
		return videoIntroduceDao.getVideoIntroduceContentByCourseID(courseID);
	}

	@Override
	public VideoIntroduce getVideoIntroduceByID(int videoIntroduceID) {
		return videoIntroduceDao.getVideoIntroduceByID(videoIntroduceID);
	}

	@Override
	public List<VideoIntroduce> getVideoIntroduces(String title,String content,Integer courseID) {
		return videoIntroduceDao.getVideoIntroduces(title,content,courseID);
	}

	@Override
	public boolean updateVideoIntroduce(VideoIntroduce videoIntroduce) {
		return videoIntroduceDao.updateVideoIntroduce(videoIntroduce)>0;
	}

}