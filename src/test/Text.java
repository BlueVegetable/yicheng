import cn.studio.zps.blue.ljy.dao.HomePageBannerDao;
import cn.studio.zps.blue.ljy.dao.ProfessionCoursePictureDao;
import cn.studio.zps.blue.ljy.domain.HomePageBanner;
import cn.studio.zps.blue.ljy.domain.ProfessionCoursePicture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Text {
    @Autowired
    private HomePageBannerDao homePageBannerDao;
    @Test
    public void test1() {
        HomePageBanner homePageBanner = new HomePageBanner();
        homePageBanner.setImage("/homePageBanner/15461874539762007440250");
        homePageBanner.setVisible((byte)0);
        homePageBanner.setUrl(null);
        homePageBanner.setPosition(1);
        System.out.println(homePageBannerDao.addHomePageBanner(homePageBanner));
    }
}
