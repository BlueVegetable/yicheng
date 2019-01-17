import cn.studio.zps.blue.ljy.dao.ArticleTypeDao;
import cn.studio.zps.blue.ljy.dao.ModuleNavigationDao;
import cn.studio.zps.blue.ljy.utils.QiNiuUpload;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Text {
    @Autowired
    private ArticleTypeDao articleTypeDao;
    @Test
    public void test1() {
        System.out.println(articleTypeDao.getArticleTypeByArticleID(13));
    }
    @Test
    public void test2() throws IOException {
        File file = Paths.get("C:\\Users\\Administrator\\Desktop\\协议书6.0.txt").toFile();
        StringBuffer stringBuffer = new StringBuffer();
        Reader reader = new FileReader(file);
        char[] value = new char[100];
        while(reader.read(value,0,99)>=0) {
            stringBuffer.append(value);
        }
        String result = stringBuffer.toString();
        result = result.replaceAll(">",">\r\n");
        Path path = Paths.get("C:\\Users\\Administrator\\Desktop\\协议书6.0.html");
        if(!Files.exists(path)) {
            Files.createFile(path);
        }
        File outFile = path.toFile();
        Writer writer = new FileWriter(outFile);
        writer.write(result);
        writer.close();
        reader.close();
    }
}
