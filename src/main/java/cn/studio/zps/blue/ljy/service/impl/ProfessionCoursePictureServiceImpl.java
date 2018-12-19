package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.ProfessionCoursePictureDao;
import cn.studio.zps.blue.ljy.domain.ProfessionCoursePicture;
import cn.studio.zps.blue.ljy.service.ProfessionCoursePictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionCoursePictureServiceImpl implements ProfessionCoursePictureService {

	@Autowired
	private ProfessionCoursePictureDao professionCoursePictureDao;

	@Override
	public boolean addProfessionCoursePicture(ProfessionCoursePicture professionCoursePicture) {
		return professionCoursePictureDao.addProfessionCoursePicture(professionCoursePicture)>0;
	}

	@Override
	public boolean deleteProfessionCoursePicture(int professionCoursePictureID) {
		return professionCoursePictureDao.deleteProfessionCoursePicture(professionCoursePictureID)>0;
	}

	@Override
	public ProfessionCoursePicture getProfessionCoursePictureByID(int professionCoursePictureID) {
		return professionCoursePictureDao.getProfessionCoursePictureByID(professionCoursePictureID);
	}

	@Override
	public List<ProfessionCoursePicture> getProfessionCoursePictures(String path, String url) {
		return professionCoursePictureDao.getProfessionCoursePictures(path,url);
	}

	@Override
	public boolean updateProfessionCoursePicture(ProfessionCoursePicture professionCoursePicture) {
		return professionCoursePictureDao.updateProfessionCoursePicture(professionCoursePicture)>0;
	}

}