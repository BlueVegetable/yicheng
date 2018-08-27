package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerDao {

    int addBanner(Banner banner);

    int deleteBanner(int id);

    int getAllCount(@Param("visible") boolean visible);

    List<Banner> getAllBanners(@Param("visible") boolean visible);

    Banner getBannerById(int id);

    int getPositionById(int id);

    int bigger(int bannerId);

    int smaller(int bannerId);

    Integer getMaxBannerPosition();

    String getBannerPath(int imageName);

    int updateBanner(Banner banner);

    int alterVisible(@Param("id") int id,@Param("visible") boolean state);

    int change(@Param("id") int id,@Param("newPosition") int position);

}
