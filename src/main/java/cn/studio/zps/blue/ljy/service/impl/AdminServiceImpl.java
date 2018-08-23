package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.AdminDao;
import cn.studio.zps.blue.ljy.domain.Admin;
import cn.studio.zps.blue.ljy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public boolean addAdmin(Admin admin){
        return adminDao.addAdmin(admin)>0;
    }

    @Override
    public boolean deleteAdmin(int id) {
        return adminDao.deleteAdmin(id)>0;
    }

    @Override
    public Admin login(String name, String password) {
        List<Admin> admins = adminDao.getAdminByName(name);
        for(Admin admin:admins) {
            if(admin.getPassword().equals(password))
                return admin;
        }
        return null;
    }

    @Override
    public Map getAdmins(String name,Integer start,Integer number) {
        Map map=new HashMap<String,Object>(2);
        map.put("data",adminDao.getAllAdmin(name,start,number));
        map.put("count",adminDao.count(name));
        return  map;
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin)>0;
    }

    @Override
    public boolean resetPassword(int id,String password) {
        return adminDao.resetPassword(id,password)>0;
    }

}
