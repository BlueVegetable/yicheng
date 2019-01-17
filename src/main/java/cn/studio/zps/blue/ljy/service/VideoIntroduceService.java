package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.VideoIntroduce;

import java.util.List;
import java.util.Map;

public interface VideoIntroduceService {

	Map<String,Object> addVideoIntroduce(VideoIntroduce videoIntroduce);

	boolean deleteVideoIntroduceByID(int videoIntroduceID);

	VideoIntroduce getVideoIntroduceByVideoID(int videoID);

	VideoIntroduce getVideoIntroduceByID(int videoIntroduceID);

	List<VideoIntroduce> getVideoIntroduces(String title, String content, Integer videoID);

	boolean updateVideoIntroduce(VideoIntroduce videoIntroduce);

}