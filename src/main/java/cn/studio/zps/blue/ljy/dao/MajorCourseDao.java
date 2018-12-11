package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.MajorCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MajorCourseDao {
    int addMajorCourse(MajorCourse majorCourse);
    MajorCourse getMajorCourseByID(int id);
    List<MajorCourse> getMajorCourses(@Param("visible") Byte visible);
    int updateMajorCourse(MajorCourse majorCourse);
}
