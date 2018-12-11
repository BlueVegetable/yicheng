package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.MajorCourseDao;
import cn.studio.zps.blue.ljy.domain.MajorCourse;
import cn.studio.zps.blue.ljy.service.MajorCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorCourseServiceImpl implements MajorCourseService {
    @Autowired
    private MajorCourseDao majorCourseDao;
    @Override
    public boolean addMajorCourse(MajorCourse majorCourse) {
        return majorCourseDao.addMajorCourse(majorCourse) > 0;
    }

    @Override
    public MajorCourse getMajorCourseByID(int id) {
        return majorCourseDao.getMajorCourseByID(id);
    }

    @Override
    public List<MajorCourse> getMajorCourses(Byte visible) {
        return majorCourseDao.getMajorCourses(visible);
    }

    @Override
    public boolean updateMajorCourse(MajorCourse majorCourse) {
        return majorCourseDao.updateMajorCourse(majorCourse) > 0;
    }
}
