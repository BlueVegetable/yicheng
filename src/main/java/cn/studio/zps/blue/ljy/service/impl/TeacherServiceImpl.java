package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.TeacherDao;
import cn.studio.zps.blue.ljy.domain.Teacher;
import cn.studio.zps.blue.ljy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;
    @Override
    public boolean addTeacher(Teacher teacher) {
        return teacherDao.addTeacher(teacher)>0;
    }

    @Override
    public Map getTeacher(String name, Integer start, Integer limit) {
        Map map=new HashMap<String,Object>(2);
        map.put("data", teacherDao.getTeacher(name, start, limit));
        map.put("count", teacherDao.count(name));
        return map;
    }

    @Override
    public boolean deleteTeacher(int teacherID) {
        return teacherDao.deleteTeacher(teacherID)>0;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        return teacherDao.updateTeacher(teacher)>0;
    }
}
