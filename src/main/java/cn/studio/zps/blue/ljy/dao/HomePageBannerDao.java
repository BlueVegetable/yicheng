package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.HomePageBanner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomePageBannerDao {

	int addHomePageBanner(HomePageBanner homePageBanner);

	int deleteHomePageBannerByID(int homePageBannerID);

	HomePageBanner getHomePageBannerByID(int homePageBannerID);

	List<HomePageBanner> getHomePageBanners(@Param("image") String image, @Param("url") String url,@Param("visible") Boolean visible);

	Long count(@Param("image") String image, @Param("url") String url,@Param("visible") Boolean visible);

	int getPositionById(int id);

	int bigger(int bannerId);

	int smaller(int bannerId);

	Integer getMaxBannerPosition();

	int updateHomePageBanner(HomePageBanner homePageBanner);

	int alterVisible(@Param("id") int id,@Param("visible") boolean state);

	int change(@Param("id") int id,@Param("newPosition") int position);

}