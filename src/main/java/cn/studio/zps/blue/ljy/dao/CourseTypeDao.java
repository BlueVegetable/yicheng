package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.CourseType;

import java.util.List;

public interface CourseTypeDao {
    CourseType getCourseTypeByID(int courseTypeID);
    List<CourseType> getCourseTypeByCourseModuleID(int courseModuleID);
}
