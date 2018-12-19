package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.ProfessionCoursePicture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProfessionCoursePictureDao {

	int addProfessionCoursePicture(ProfessionCoursePicture professionCoursePicture);

	int deleteProfessionCoursePicture(int professionCoursePictureID);

	ProfessionCoursePicture getProfessionCoursePictureByID(int professionCoursePictureID);

	List<ProfessionCoursePicture> getProfessionCoursePictures(@Param("path") String path, @Param("url") String url);

	int updateProfessionCoursePicture(ProfessionCoursePicture professionCoursePicture);

}