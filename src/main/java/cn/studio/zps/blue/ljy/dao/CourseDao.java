package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Course;

import java.util.List;

public interface CourseDao {
    int addCourse(Course course);
    Course getCourseByID(int courseID);
    List<Course> getCoursesByCourseTypeID(int courseTypeID);
    List<Course> getAllCourses();
    int updateCourse(Course course);
}
