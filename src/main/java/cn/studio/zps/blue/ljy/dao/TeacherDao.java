package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDao {

    int addTeacher(Teacher teacher);

    List<Teacher> getTeacher(@Param("name") String name , @Param("start") Integer start , @Param("number") Integer number);

    int count(@Param("name") String name);

    int deleteTeacher(@Param("teacherID") int teacherID);

    int updateTeacher(Teacher teacher);

    List<Teacher> getAllTeacher();
}
