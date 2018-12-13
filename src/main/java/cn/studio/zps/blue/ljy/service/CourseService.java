package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.Course;

import java.util.List;

public interface CourseService {
    Course getCourseByID(int courseID);
    List<Course> getCourseByCourseTypeID(int courseTypeID);
}
