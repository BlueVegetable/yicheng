package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherService {

    boolean addTeacher(Teacher teacher);

    Map getTeacher(String name , Integer start , Integer limit);

    boolean deleteTeacher(int teacherID);

    boolean updateTeacher(Teacher teacher);

    List<Teacher> getAllTeacher();
}
