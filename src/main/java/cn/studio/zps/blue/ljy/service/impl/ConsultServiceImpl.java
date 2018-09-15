package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.ConsultDao;
import cn.studio.zps.blue.ljy.domain.Consult;
import cn.studio.zps.blue.ljy.service.ConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    public int getAllCount(){
        return consultDao.getAllCount();
    }

    @Override
    public int countByState(int state) {
        return consultDao.countByState(state);
    }

    @Override
    public Consult getConsultById(int consultId){
        return consultDao.getConsultById(consultId);
    }

    @Override
    public List<Consult> getConsults(int page,int number){
        int start=(page-1)*number;
        return consultDao.getAllConsult(start,number);
    }

    @Override
    public List<Consult> selectConsults(Map map) {
        return consultDao.getConsultLimited(map);
    }

    @Override
    public int limitConsultCount(Integer consultId,String name,String remark,String phoneNumber) {
        Map<String,Object>map=new LinkedHashMap<>();

        map.put("id",consultId);
        map.put("name",name);
        map.put("remark",remark);
        map.put("phoneNumber",phoneNumber);

        return consultDao.getLimitedCount(map);
    }

    @Override
    public Map<String,Long> classifyCount(){
        List<Map<String,Object>> values=consultDao.getAllAttribution();
        Map<String,Long> all=new LinkedHashMap<>();
        for(Map<String,Object> value:values) {
            all.put((String)value.get("attribution"),(Long)value.get("number"));
        }
        return all;
    }

    @Override
    public boolean updateConsult(Consult consult){
        return consultDao.updateConsult(consult)>0;
    }

    @Override
    public boolean alterState(int id,int state) { return consultDao.alterState(id,state)>0; }

}
