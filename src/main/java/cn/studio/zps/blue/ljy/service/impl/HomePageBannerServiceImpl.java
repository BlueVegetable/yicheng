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
	public List<HomePageBanner> getHomePageBanners(String image,String url,Boolean visible) {
		return homePageBannerDao.getHomePageBanners(image,url,visible);
	}

	@Override
	public Long count(String image, String url, Boolean visible) {
		return homePageBannerDao.count(image, url, visible);
	}

	@Override
	public boolean updateHomePageBanner(HomePageBanner homePageBanner) {
		return homePageBannerDao.updateHomePageBanner(homePageBanner)>0;
	}

	@Override
	public int bigger(int bannerId) {
		return homePageBannerDao.bigger(bannerId);
	}

	@Override
	public int smaller(int bannerId) {
		return homePageBannerDao.smaller(bannerId);
	}

	@Override
	public int getMaxPosition() {
		return homePageBannerDao.getMaxBannerPosition();
	}

	@Override
	public boolean alterVisible(int id, boolean visible) {
		return homePageBannerDao.alterVisible(id,visible)>0;
	}

	@Override
	public boolean exchange(int id, int anotherID) {
		int temp=homePageBannerDao.getPositionById(id);
		if(changePosition(id,homePageBannerDao.getPositionById(anotherID)) && changePosition(anotherID,temp) )
			return true;
		return false;
	}

	private boolean changePosition(int id,int position) {
		return homePageBannerDao.change(id,position)>0;
	}
}