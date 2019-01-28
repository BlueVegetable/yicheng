package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.Course;

import java.util.List;

public interface CourseService {
    boolean addCourse(Course course);
    Course getCourseByID(int courseID);
    List<Course> getCourseByCourseTypeID(int courseTypeID);
    List<Course> getAllCourses();
    boolean updateCourse(Course course);
}
