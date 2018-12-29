package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.HomePageBannerDao;
import cn.studio.zps.blue.ljy.domain.HomePageBanner;
import cn.studio.zps.blue.ljy.service.HomePageBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomePageBannerServiceImpl implements HomePageBannerService {

	@Autowired
	private HomePageBannerDao homePageBannerDao;

	@Override
	public boolean addHomePageBanner(HomePageBanner homePageBanner) {
		return homePageBannerDao.addHomePageBanner(homePageBanner)>0;
	}

	@Override
	public boolean deleteHomePageBannerByID(int homePageBannerID) {
		return homePageBannerDao.deleteHomePageBannerByID(homePageBannerID)>0;
	}

	@Override
	public HomePageBanner getHomePageBannerByID(int homePageBannerID) {
		return homePageBannerDao.getHomePageBannerByID(homePageBannerID);
	}

	@Override
	public List<HomePageBanner> getHomePageBanners(String image,String url) {
		return homePageBannerDao.getHomePageBanners(image,url);
	}

	@Override
	public boolean updateHomePageBanner(HomePageBanner homePageBanner) {
		return homePageBannerDao.updateHomePageBanner(homePageBanner)>0;
	}

}