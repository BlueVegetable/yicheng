package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.Admin;

import java.util.Map;

public interface AdminService {

    boolean addAdmin(Admin admin);

    boolean deleteAdmin(int id);

    Admin login(String name,String password);

    Map getAdmins(String name,Integer start,Integer number);

    boolean updateAdmin(Admin admin);

    boolean resetPassword(int id,String password);

}
