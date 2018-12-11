package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.EducationLevelDao;
import cn.studio.zps.blue.ljy.domain.EducationLevel;
import cn.studio.zps.blue.ljy.service.EducationLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationLevelServiceImpl implements EducationLevelService {
    @Autowired
    private EducationLevelDao educationLevelDao;
    @Override
    public boolean addEducationLevel(EducationLevel educationLevel) {
        return educationLevelDao.addEducationLevel(educationLevel) > 0;
    }

    @Override
    public EducationLevel getEducationLevelByID(int id) {
        return educationLevelDao.getEducationLevelByID(id);
    }

    @Override
    public List<EducationLevel> getEducationLevels(Byte visible) {
        return educationLevelDao.getEducationLevels(visible);
    }

    @Override
    public boolean updateEducationLevel(EducationLevel educationLevel) {
        return educationLevelDao.updateEducationLevel(educationLevel) > 0;
    }
}
