package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.Consult;

import java.util.List;
import java.util.Map;

public interface ConsultService {

    int UN_DEALING_STATE = 0;

    boolean addConsult(Consult consult);

    boolean deleteConsult(int id);

    int getAllCount(short applyMethod);

    List<Map<String,Object>> countByState(List<Short> applyMethods);

    Consult getConsultById(int consultId);

    List<Consult> getConsults(int page,int number,short applyMethod);

    List<Consult> selectConsults(Map map);

    int limitConsultCount(Integer consultId,String name,String remark,String phoneNumber,Short applyMethod);

    Map<String,Long> classifyCount();

    boolean updateConsult(Consult consult);

    boolean alterState(int id,int state);

}
