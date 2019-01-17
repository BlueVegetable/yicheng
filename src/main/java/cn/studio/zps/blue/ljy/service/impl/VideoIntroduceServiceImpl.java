import java.util.List;

@Service
public class VideoIntroduceServiceImpl implements VideoIntroduceService{

	@Autowired
	private VideoIntroduceDao videoIntroduceDao;

	@Override
	public boolean addVideoIntroduce(VideoIntroduce videoIntroduce) {
		return videoIntroduceDao.addVideoIntroduce(videoIntroduce)>0;
	}

	@Override
	public boolean deleteVideoIntroduceByID(int videoIntroduceID) {
		return videoIntroduceDao.deleteVideoIntroduceByID(videoIntroduceID)>0;
	}

	@Override
	public VideoIntroduce getVideoIntroduceByID(int videoIntroduceID) {
		return videoIntroduceDao.getVideoIntroduceByID(videoIntroduceID);
	}

	@Override
	public List<VideoIntroduce> getVideoIntroduces(int id,String title,String content,int videoID) {
		return videoIntroduceDao.getVideoIntroduces(id,title,content,videoID);
	}

	@Override
	public boolean updateVideoIntroduce(VideoIntroduce videoIntroduce) {
		return videoIntroduceDao.updateVideoIntroduce(videoIntroduce)>0;
	}

}