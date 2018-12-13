package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.CourseType;

import java.util.List;

public interface CourseTypeService {
    CourseType getCourseTypeByCourseID(int courseID);
    List<CourseType> getCourseTypesByCourseModuleID(int courseModuleID);
}
