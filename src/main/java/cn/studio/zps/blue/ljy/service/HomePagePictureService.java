package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.HomePagePicture;

import java.util.List;
import java.util.Map;

public interface HomePagePictureService {
    Map addHomePagePicture(HomePagePicture homePagePicture);
    boolean deleteHomePagePicture(int id);
    HomePagePicture getHomePagePictureByID(int homePagePictureID);
    List<HomePagePicture> getAllHomePagePictures();
    boolean updateHomePagePicture(HomePagePicture homePagePicture);
}
