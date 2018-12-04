package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.HomePagePictureDao;
import cn.studio.zps.blue.ljy.domain.HomePagePicture;
import cn.studio.zps.blue.ljy.service.HomePagePictureService;
import cn.studio.zps.blue.ljy.utils.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HomePagePictureImpl implements HomePagePictureService {
    private @Autowired HomePagePictureDao homePagePictureDao;
    private static final int TOPEST_MAX_NUMBER = 1;
    private static final int UN_TOPEST_MAX_NUMBER = 2;
    @Override
    public Map addHomePagePicture(HomePagePicture homePagePicture) {
        Map result = new HashMap();
        long number = homePagePictureDao.count(homePagePicture.getTopest());
        long numberLimit = homePagePicture.getTopest()?TOPEST_MAX_NUMBER:UN_TOPEST_MAX_NUMBER;
        if (number >= numberLimit) {
            result.put("code",false);
            result.put("msg","广告图片超过了限度");
            return result;
        }
        if(homePagePictureDao.addHomePagePicture(homePagePicture) > 0) {
            result.put("code",true);
            result.put("msg",null);
        } else {
            result.put("code",false);
            result.put("msg","服务器出错");
        }
        return result;
    }

    @Override
    public boolean deleteHomePagePicture(int id) {
        HomePagePicture homePagePicture = homePagePictureDao.getHomePagePictureByID(id);
        FileUpload.deleteHomePagePicture(homePagePicture.getImage());
        return homePagePictureDao.deleteHomePagePicture(id) > 0;
    }

    @Override
    public HomePagePicture getHomePagePictureByID(int homePagePictureID) {
        return homePagePictureDao.getHomePagePictureByID(homePagePictureID);
    }

    @Override
    public List<HomePagePicture> getAllHomePagePictures() {
        return homePagePictureDao.getAllHomePagePictures();
    }

    @Override
    public boolean updateHomePagePicture(HomePagePicture homePagePicture) {
        HomePagePicture origin = homePagePictureDao.getHomePagePictureByID(homePagePicture.getId());
        if (!origin.getImage().equals(homePagePicture.getImage())) {
            FileUpload.deleteHomePagePicture(origin.getImage());
        }
        return homePagePictureDao.updateHomePagePicture(homePagePicture) > 0;
    }
}
