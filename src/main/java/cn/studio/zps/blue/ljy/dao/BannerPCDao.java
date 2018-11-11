package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.BannerPC;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerPCDao {
    int addBannerPC(BannerPC banner);

    int deleteBannerPC(int id);

    int getAllCount(@Param("visible") boolean visible);

    List<BannerPC> getAllBannerPCs(@Param("visible") boolean visible);

    List<BannerPC> getBannerPCsByLocation(Integer location);

    BannerPC getBannerPCById(int id);

    int getPositionById(int id);

    int bigger(int bannerId);

    int smaller(int bannerId);

    Integer getMaxBannerPCPosition();

    int updateBannerPC(BannerPC banner);

    int alterVisible(@Param("id") int id,@Param("visible") boolean state);

    int change(@Param("id") int id,@Param("newPosition") int position);
}
