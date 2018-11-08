package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.Address;

import java.util.Map;


public interface AddressService {

    boolean addAddress(Address address);

    boolean deleteAddress(int addressId);

    Map getAllAddress(String name , Integer start , Integer limit);

    boolean updateAddress(Address address);
}
