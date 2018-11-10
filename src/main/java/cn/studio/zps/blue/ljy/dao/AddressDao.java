package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressDao {

    int addAddress(Address address);

    int deleteAddress(@Param("addressID") int addressID);
    /*
    这个接口可以同时实现按照条件查找地址信息和查找全部地址信息
     */
    List<Address> getAllAddress(@Param("name") String name , @Param("start") Integer start , @Param("number") Integer number);

    int count(@Param("name") String name);

    int updateAddress(Address address);

    List<Address> getAddressUI();
}
