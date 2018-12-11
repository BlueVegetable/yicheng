package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.MajorCourse;

import java.util.List;

public interface MajorCourseService {
    boolean addMajorCourse(MajorCourse majorCourse);
    MajorCourse getMajorCourseByID(int id);
    List<MajorCourse> getMajorCourses(Byte visible);
    boolean updateMajorCourse(MajorCourse majorCourse);
}
