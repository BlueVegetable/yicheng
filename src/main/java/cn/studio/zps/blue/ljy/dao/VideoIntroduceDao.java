public interface VideoIntroduceDao {

	int addVideoIntroduce(VideoIntroduce videoIntroduce);

	int deleteVideoIntroduceByID(int videoIntroduceID);

	VideoIntroduce getVideoIntroduceByID(int videoIntroduceID);

	List<VideoIntroduce> getVideoIntroduces(@Param("id")int id,@Param("title")String title,@Param("content")String content,@Param("videoID")int videoID);

	int updateVideoIntroduce(VideoIntroduce videoIntroduce);

}