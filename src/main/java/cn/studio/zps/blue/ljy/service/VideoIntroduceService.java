public interface VideoIntroduceService {

	boolean addVideoIntroduce(VideoIntroduce videoIntroduce);

	boolean deleteVideoIntroduceByID(int videoIntroduceID);

	VideoIntroduce getVideoIntroduceByID(int videoIntroduceID);

	List<VideoIntroduce> getVideoIntroduces(int id,String title,String content,int videoID);

	boolean updateVideoIntroduce(VideoIntroduce videoIntroduce);

}