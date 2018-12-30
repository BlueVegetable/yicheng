package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.HomePageBanner;

import java.util.List;

public interface HomePageBannerService {

	boolean addHomePageBanner(HomePageBanner homePageBanner);

	boolean deleteHomePageBannerByID(int homePageBannerID);

	HomePageBanner getHomePageBannerByID(int homePageBannerID);

	int bigger(int bannerId);

	int smaller(int bannerId);

	int getMaxPosition();

	List<HomePageBanner> getHomePageBanners(String image, String url,Boolean visible);

	Long count(String image, String url,Boolean visible);

	boolean updateHomePageBanner(HomePageBanner homePageBanner);

	boolean alterVisible(int id,boolean visible);

	boolean exchange(int id,int anotherID);

}