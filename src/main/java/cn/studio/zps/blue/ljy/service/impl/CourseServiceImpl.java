package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.CourseDao;
import cn.studio.zps.blue.ljy.domain.Course;
import cn.studio.zps.blue.ljy.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public Course getCourseByID(int courseID) {
        return courseDao.getCourseByID(courseID);
    }

    @Override
    public List<Course> getCourseByCourseTypeID(int courseTypeID) {
        return courseDao.getCoursesByCourseTypeID(courseTypeID);
    }
}
