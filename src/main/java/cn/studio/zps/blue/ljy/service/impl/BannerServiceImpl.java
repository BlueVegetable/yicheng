package cn.studio.zps.blue.ljy.service.impl;


import cn.studio.zps.blue.ljy.dao.BannerDao;
import cn.studio.zps.blue.ljy.domain.Banner;
import cn.studio.zps.blue.ljy.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerDao bannerDao;

    public boolean addBanner(Banner banner) {
        banner.setPosition(getMaxPosition()+1);
        return bannerDao.addBanner(banner)>0;
    }

    public boolean deleteBanner(int id) {
        return bannerDao.deleteBanner(id)>0;
    }

    public List<Banner> getBanner(boolean visible) {
        return bannerDao.getAllBanners(visible);
    }

    public Banner getBanner(int id) {
        return bannerDao.getBannerById(id);
    }

    public int getCount(boolean visible) {
        return bannerDao.getAllCount(visible);
    }

    public int bigger(int bannerId) {
        return bannerDao.bigger(bannerId);
    }

    public int smaller(int bannerId) {
        return bannerDao.smaller(bannerId);
    }

    public int getMaxPosition() { return bannerDao.getMaxBannerPosition(); }

    public boolean alterVisible(int id,boolean visible ) {
        return bannerDao.alterVisible(id,visible)>0;
    }

    public boolean exchange(int id,int anotherID){
        int temp=bannerDao.getPositionById(id);
        if(changePosition(id,bannerDao.getPositionById(anotherID)) && changePosition(anotherID,temp) )
            return true;
        return false;
    }

    private boolean changePosition(int id,int position) {
        return bannerDao.change(id,position)>0;
    }

}
