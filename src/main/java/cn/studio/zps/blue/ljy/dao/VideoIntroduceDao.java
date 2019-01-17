package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.VideoIntroduce;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoIntroduceDao {

	int addVideoIntroduce(VideoIntroduce videoIntroduce);

	int deleteVideoIntroduceByID(int videoIntroduceID);

	Long count(int videoID);

	VideoIntroduce getVideoIntroduceByVideoID(int videoID);

	VideoIntroduce getVideoIntroduceByID(int videoIntroduceID);

	List<VideoIntroduce> getVideoIntroduces(@Param("title") String title, @Param("content") String content, @Param("videoID") Integer videoID);

	int updateVideoIntroduce(VideoIntroduce videoIntroduce);

}