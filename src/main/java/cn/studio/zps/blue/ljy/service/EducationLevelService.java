package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.EducationLevel;

import java.util.List;

public interface EducationLevelService {
    boolean addEducationLevel(EducationLevel educationLevel);
    EducationLevel getEducationLevelByID(int id);
    List<EducationLevel> getEducationLevels(Byte visible);
    boolean updateEducationLevel(EducationLevel educationLevel);
}
