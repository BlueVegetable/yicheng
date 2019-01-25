package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.VideoIntroduce;

import java.util.List;
import java.util.Map;

public interface VideoIntroduceService {

	Map<String,Object> addVideoIntroduce(VideoIntroduce videoIntroduce);

	boolean deleteVideoIntroduceByID(int videoIntroduceID);

	VideoIntroduce getVideoIntroduceByCourseID(int courseID);

	VideoIntroduce getVideoIntroduceContentByCourseID(int courseID);

	VideoIntroduce getVideoIntroduceByID(int videoIntroduceID);

	List<VideoIntroduce> getVideoIntroduces(String title, String content, Integer courseID);

	boolean updateVideoIntroduce(VideoIntroduce videoIntroduce);

}