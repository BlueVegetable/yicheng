package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.HomePageBanner;

import java.util.List;

public interface HomePageBannerService {

	boolean addHomePageBanner(HomePageBanner homePageBanner);

	boolean deleteHomePageBannerByID(int homePageBannerID);

	HomePageBanner getHomePageBannerByID(int homePageBannerID);

	List<HomePageBanner> getHomePageBanners(String image, String url);

	boolean updateHomePageBanner(HomePageBanner homePageBanner);

}