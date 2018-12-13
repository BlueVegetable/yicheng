package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.CourseModule;

import java.util.List;

public interface CourseModuleService {
    CourseModule getCourseModuleByID(int courseModuleID);
    List<CourseModule> getAllCourseModules();
}
