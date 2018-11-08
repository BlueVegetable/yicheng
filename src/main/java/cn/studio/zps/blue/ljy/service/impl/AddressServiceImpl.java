package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.AddressDao;
import cn.studio.zps.blue.ljy.domain.Address;
import cn.studio.zps.blue.ljy.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;
    @Override
    public boolean addAddress(Address address) {
        return addressDao.addAddress(address)>0;
    }

    @Override
    public boolean deleteAddress(int addressId) {
        return addressDao.deleteAddress(addressId)>0;
    }

    @Override
    public Map getAllAddress(String name, Integer start, Integer limit) {
        Map map=new HashMap<String,Object>(2);
        map.put("data" , addressDao.getAllAddress(name, start, limit));
        map.put("count" , addressDao.count(name));
        return map;
    }

    @Override
    public boolean updateAddress(Address address) {
        return addressDao.updateAddress(address)>0;
    }
}
