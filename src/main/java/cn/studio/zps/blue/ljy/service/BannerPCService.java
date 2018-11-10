package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.Banner;
import cn.studio.zps.blue.ljy.domain.BannerPC;

import java.util.List;

public interface BannerPCService {
    boolean addBannerPC(BannerPC bannerPC);

    boolean deleteBannerPC(int id);

    List<BannerPC> getBannerPC(boolean visible);

    List<BannerPC> getBannerPCsByLocation(Integer location);

    BannerPC getBannerPC(int id);

    int getCount(boolean visible);

    int bigger(int bannerPCId);

    int smaller(int bannerPCId);

    int getMaxPosition();

    boolean updateBannerPC(BannerPC bannerPC);

    boolean alterVisible(int id,boolean visible );

    boolean exchange(int id,int anotherID);
}
