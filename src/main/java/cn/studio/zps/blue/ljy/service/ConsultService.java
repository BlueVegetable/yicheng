package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.Consult;

import java.util.List;
import java.util.Map;

public interface ConsultService {

    boolean addConsult(Consult consult);

    boolean deleteConsult(int id);

    int getAllCount();

    Consult getConsultById(int consultId);

    List<Consult> getConsults(int page,int number);

    List<Consult> selectConsults(Map map);

    int limitConsultCount(Integer consultId,String name,String remark,String phoneNumber);

    Map<String,Long> classifyCount();

    boolean updateConsult(Consult consult);

    boolean alterState(int id,int state);

}
