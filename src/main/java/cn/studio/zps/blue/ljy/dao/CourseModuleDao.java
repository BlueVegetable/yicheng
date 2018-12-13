package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.CourseModule;

import java.util.List;

public interface CourseModuleDao {
    CourseModule getCourseModuleByID(int courseModuleID);
    List<CourseModule> getAllCourseModules();
}
