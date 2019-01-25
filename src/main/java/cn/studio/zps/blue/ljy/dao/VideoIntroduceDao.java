package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.VideoIntroduce;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoIntroduceDao {

	int addVideoIntroduce(VideoIntroduce videoIntroduce);

	int deleteVideoIntroduceByID(int videoIntroduceID);

	Long count(int courseID);

	VideoIntroduce getVideoIntroduceByCourseID(int courseID);

	VideoIntroduce getVideoIntroduceContentByCourseID(int courseID);

	VideoIntroduce getVideoIntroduceByID(int videoIntroduceID);

	List<VideoIntroduce> getVideoIntroduces(@Param("title") String title, @Param("content") String content, @Param("courseID") Integer courseID);

	int updateVideoIntroduce(VideoIntroduce videoIntroduce);

}