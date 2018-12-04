package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.HomePagePicture;

import java.util.List;

public interface HomePagePictureDao {
    int addHomePagePicture(HomePagePicture homePagePicture);
    int deleteHomePagePicture(int id);
    Long count(boolean topest);
    HomePagePicture getHomePagePictureByID(int id);
    List<HomePagePicture> getAllHomePagePictures();
    int updateHomePagePicture(HomePagePicture homePagePicture);
}
