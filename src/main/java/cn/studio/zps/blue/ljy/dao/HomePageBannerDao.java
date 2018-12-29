package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.HomePageBanner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomePageBannerDao {

	int addHomePageBanner(HomePageBanner homePageBanner);

	int deleteHomePageBannerByID(int homePageBannerID);

	HomePageBanner getHomePageBannerByID(int homePageBannerID);

	List<HomePageBanner> getHomePageBanners(@Param("image") String image, @Param("url") String url);

	int updateHomePageBanner(HomePageBanner homePageBanner);

}