package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.CourseDao;
import cn.studio.zps.blue.ljy.dao.CourseTypeDao;
import cn.studio.zps.blue.ljy.domain.Course;
import cn.studio.zps.blue.ljy.domain.CourseType;
import cn.studio.zps.blue.ljy.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseTypeServiceImpl implements CourseTypeService {
    private @Autowired CourseTypeDao courseTypeDao;
    private @Autowired CourseDao courseDao;
    @Override
    public CourseType getCourseTypeByCourseID(int courseID) {
        Course course = courseDao.getCourseByID(courseID);
        CourseType courseType = courseTypeDao.getCourseTypeByID(course.getCourseTypeID());
        return courseType;
    }
}
