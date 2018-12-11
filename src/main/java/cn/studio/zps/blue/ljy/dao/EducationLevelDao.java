package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.EducationLevel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EducationLevelDao {
    int addEducationLevel(EducationLevel educationLevel);
    EducationLevel getEducationLevelByID(int id);
    List<EducationLevel> getEducationLevels(@Param("visible") Byte visible);
    int updateEducationLevel(EducationLevel educationLevel);
}
