import cn.studio.zps.blue.ljy.controller.AddressController;
import cn.studio.zps.blue.ljy.dao.AddressDao;
import cn.studio.zps.blue.ljy.dao.TeacherDao;
import cn.studio.zps.blue.ljy.domain.Address;
import cn.studio.zps.blue.ljy.domain.Teacher;
import cn.studio.zps.blue.ljy.service.AddressService;
import cn.studio.zps.blue.ljy.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AddressTest {
    @Autowired
    private AddressService addressService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private TeacherDao teacherDao;

    @Test
    public void  testAddress(){
        Address address = new Address(3,"东莞","东莞","东莞");
   //    addressService.addAddress(address);
   //    boolean flag = addressService.updateAddress(address);
     //  System.out.println(flag);
       List<Address> list =  addressService.getAddressUI();
       for(Address address1 : list){
           System.out.println(address1);
       }

    }
//    @Test
//    public void testTeacher(){
//        Teacher teacher = new Teacher(3,"111","111","111","321");
//        teacherService.updateTeacher(teacher);
//       // teacherDao.addTeacher(teacher);
//    }

}
