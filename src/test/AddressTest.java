import cn.studio.zps.blue.ljy.dao.AddressDao;
import cn.studio.zps.blue.ljy.domain.Address;
import cn.studio.zps.blue.ljy.service.AddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AddressTest {
    @Autowired
    private AddressService addressService;
    @Autowired
    private AddressDao addressDao;
    @Test
    public void  testAddress(){
        Address address = new Address(2,"东莞123","东莞","东莞");
       addressService.addAddress(address);

    }


}
