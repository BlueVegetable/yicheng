package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Consult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Adminstrator
 */
public interface ConsultDao {

    /**
     * 开始报名
     * @param consult 报名表
     * @return 添加成功的数量
     */
    int addConsult(Consult consult);

    /**
     * 删除报名表
     * @param consultId 报名表id
     * @return 删除成功地条数
     */
    int deleteConsult(int consultId);

    int getAllCount(@Param("applyMethod") short applyMethod);

    List<Map<String,Object>> getAllUnDealingNumber();

    Consult getConsultById(int consultId);

    List<Consult> getAllConsult(@Param("start") int start,@Param("number") int number,@Param("applyMethod") short applyMethod);

    List<Consult> getConsultLimited(Map<String,Object> parameters);

    List<Map<String,Object>> getAllAttribution();

    int getLimitedCount(Map<String,Object> parameters);

    int updateConsult(Consult consult);

    int alterState(@Param("id") int id,@Param("state") int state);

}
