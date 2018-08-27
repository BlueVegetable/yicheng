package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.Banner;

import java.util.List;

public interface BannerService {

    boolean addBanner(Banner banner);

    boolean deleteBanner(int id);

    List<Banner> getBanner(boolean visible);

    Banner getBanner(int id);

    int getCount(boolean visible);

    int bigger(int bannerId);

    int smaller(int bannerId);

    int getMaxPosition();

    boolean updateBanner(Banner banner);

    boolean alterVisible(int id,boolean visible );

    boolean exchange(int id,int anotherID);

}
