package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.BannerPCDao;
import cn.studio.zps.blue.ljy.domain.Banner;
import cn.studio.zps.blue.ljy.domain.BannerPC;
import cn.studio.zps.blue.ljy.service.BannerPCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "BannerPCServiceImpl")
public class BannerPCServiceImpl implements BannerPCService {
    private @Autowired BannerPCDao bannerPCDao;

    @Override
    public boolean addBannerPC(BannerPC bannerPC) {
        bannerPC.setPosition(getMaxPosition()+1);
        return bannerPCDao.addBannerPC(bannerPC)>0;
    }

    @Override
    public boolean deleteBannerPC(int id) {
        return bannerPCDao.deleteBannerPC(id) > 0;
    }

    @Override
    public List<BannerPC> getBannerPC(boolean visible) {
        return bannerPCDao.getAllBannerPCs(visible);
    }

    @Override
    public BannerPC getBannerPC(int id) {
        return bannerPCDao.getBannerPCById(id);
    }

    @Override
    public int getCount(boolean visible) {
        return bannerPCDao.getAllCount(visible);
    }

    @Override
    public int bigger(int bannerPCId) {
        return bannerPCDao.bigger(bannerPCId);
    }

    @Override
    public int smaller(int bannerPCId) {
        return bannerPCDao.smaller(bannerPCId);
    }

    @Override
    public int getMaxPosition() {
        return bannerPCDao.getMaxBannerPCPosition();
    }

    @Override
    public boolean updateBannerPC(BannerPC bannerPC) {
        return updateBannerPC(bannerPC);
    }

    @Override
    public boolean alterVisible(int id, boolean visible) {
        return bannerPCDao.alterVisible(id,visible) > 0;
    }

    @Override
    public boolean exchange(int id, int anotherID) {
        int temp=bannerPCDao.getPositionById(id);
        if(changePosition(id,bannerPCDao.getPositionById(anotherID)) && changePosition(anotherID,temp) )
            return true;
        return false;
    }
    private boolean changePosition(int id,int position) {
        return bannerPCDao.change(id,position)>0;
    }
}
