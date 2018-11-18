package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Course;

import java.util.List;

public interface CourseDao {
    Course getCourseByID(int courseID);
    List<Course> getCoursesByCourseTypeID(int courseTypeID);
}
