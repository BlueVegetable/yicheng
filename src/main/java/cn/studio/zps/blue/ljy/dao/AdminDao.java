package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao {

    int addAdmin(Admin admin);

    int deleteAdmin(int adminID);

    Admin getAdminById(int id);

    List<Admin> getAdminByName(String adminName);

    List<Admin> getAllAdmin(@Param("name") String name,@Param("start")Integer start,@Param("number") Integer number);

    int count(@Param("name") String name);

    int updateAdmin(Admin admin);

    int resetPassword(@Param("id") int id,@Param("password") String password);

}
