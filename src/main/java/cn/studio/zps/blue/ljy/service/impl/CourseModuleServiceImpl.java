package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.CourseModuleDao;
import cn.studio.zps.blue.ljy.domain.CourseModule;
import cn.studio.zps.blue.ljy.service.CourseModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseModuleServiceImpl implements CourseModuleService {
    private @Autowired CourseModuleDao courseModuleDao;
    @Override
    public CourseModule getCourseModuleByID(int courseModuleID) {
        return courseModuleDao.getCourseModuleByID(courseModuleID);
    }

    @Override
    public List<CourseModule> getAllCourseModules() {
        return courseModuleDao.getAllCourseModules();
    }
}
