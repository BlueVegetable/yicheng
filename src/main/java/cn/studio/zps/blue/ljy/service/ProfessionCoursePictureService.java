package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.ProfessionCoursePicture;

import java.util.List;

public interface ProfessionCoursePictureService {

	boolean addProfessionCoursePicture(ProfessionCoursePicture professionCoursePicture);

	boolean deleteProfessionCoursePicture(int professionCoursePictureID);

	ProfessionCoursePicture getProfessionCoursePictureByID(int professionCoursePictureID);

	List<ProfessionCoursePicture> getProfessionCoursePictures(String path, String url);

	boolean updateProfessionCoursePicture(ProfessionCoursePicture professionCoursePicture);

}