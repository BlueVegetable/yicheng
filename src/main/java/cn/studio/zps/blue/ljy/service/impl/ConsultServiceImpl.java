package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.ConsultDao;
import cn.studio.zps.blue.ljy.domain.Consult;
import cn.studio.zps.blue.ljy.service.ConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ConsultServiceImpl implements ConsultService {

    @Autowired
    private ConsultDao consultDao;

    @Override
    public boolean addConsult(Consult consult){
        return consultDao.addConsult(consult)>0;
    }

    @Override
    public boolean deleteConsult(int id){
        return consultDao.deleteConsult(id)>0;
    }

    @Override
    public int getAllCount(short applyMethod){
        return consultDao.getAllCount(applyMethod);
    }

    @Override
    public List<Map<String,Object>> countByState(List<Short> applyMethods) {
        List<Map<String,Object>> results = new ArrayList<>();
        for(Short applyMethod:applyMethods) {
            Map<String,Object> result = consultDao.getUnDealingNumber(applyMethod);
            result.put("applyMethod",applyMethod);
            results.add(result);
        }
        return results;
    }

    @Override
    public Consult getConsultById(int consultId){
        return consultDao.getConsultById(consultId);
    }

    @Override
    public List<Consult> getConsults(int page,int number,short applyMethod){
        int start=(page-1)*number;
        return consultDao.getAllConsult(start,number,applyMethod);
    }

    @Override
    public List<Consult> selectConsults(Map map) {
        return consultDao.getConsultLimited(map);
    }

    @Override
    public List<Map<String, Object>> statistic() {
        return consultDao.statistic();
    }

    @Override
    public List<Map<String, Object>> statisticMonth(int year) {
        List<Map<String,Object>> result = new ArrayList<>();
        for (int month = 1;month <= 12;month++) {
            Map<String,Object> datas = new HashMap<>();
            datas.put("name",month+"月");
            String start = year+"-"+month+"-"+"01";
            String finish = year + "-" + (month+1) + "-01";
            datas.put("value",consultDao.statisticMonth(start,finish));
            result.add(datas);
        }
        return result;
    }

    @Override
    public int limitConsultCount(Integer consultId,String name,String remark,String phoneNumber,Short applyMethod ) {
        Map<String,Object>map=new LinkedHashMap<>();

        map.put("id",consultId);
        map.put("name",name);
        map.put("remark",remark);
        map.put("phoneNumber",phoneNumber);
        map.put("applyMethod",applyMethod);

        return consultDao.getLimitedCount(map);
    }

    @Override
    public List<Map<String, Object>> getLimitNumberClassfy(int rank) {
        return consultDao.getLimitNumberClassfy(rank);
    }

    @Override
    public boolean updateConsult(Consult consult){
        return consultDao.updateConsult(consult)>0;
    }

    @Override
    public boolean alterState(int id,int state) { return consultDao.alterState(id,state)>0; }

}
