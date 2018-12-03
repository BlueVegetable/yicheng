import cn.studio.zps.blue.ljy.dao.ArticleDao;
import cn.studio.zps.blue.ljy.dao.ConsultDao;
import cn.studio.zps.blue.ljy.domain.Consult;
import cn.studio.zps.blue.ljy.service.ConsultService;
import cn.studio.zps.blue.ljy.service.ModuleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ConsultTest {

    @Autowired
    private ConsultDao consultDao;

    @Autowired
    private ConsultService consultService;
    private @Autowired ModuleService moduleService;
    private @Autowired ArticleDao articleDao;

    public @Test void test1() {
        List<Short> parameters = new ArrayList<>();
        parameters.add((short)0);
        parameters.add((short)1);
        parameters.add((short)2);
        parameters.add((short)3);
        parameters.add((short)4);
        parameters.add((short)5);
        System.out.println(consultService.countByState(parameters));
    }
    public @Test void test2() {
        System.out.println();
    }
    public @Test void test3() {
        System.out.println(consultDao.getLimitNumberClassfy(5));
    }
    public @Test void test4() {
        Pattern pattern = Pattern.compile("<img\\s*((?<key>[^=]+)=\"*(?<value>[^\"]+)\")+?\\s*/?>");
        String origin = "<img src=\"http://localhost:80/upload/ueditor/image/1535954859039-1244994524-2147483647.jpeg\" title=\"1535954859039-1244994524-2147483647.jpeg\" alt=\"1535954859039-1244994524-2147483647.jpeg\" width=\"621\" height=\"318\"/>" +
                "hahahaha<img src=\"http://localhost:80/upload/ueditor/image/1535954859039-1244994524-2147483647.jpeg\" title=\"1535954859039-1244994524-2147483647.jpeg\" alt=\"1535954859039-1244994524-2147483647.jpeg\" width=\"621\" height=\"318\"/>";
        String now = new String(origin);
        Matcher matcher = pattern.matcher(now);
        now = matcher.replaceAll("[图片]");
        System.out.println(now);
    }
    public @Test void test5() {
        System.out.println(moduleService.getAllModules());
    }
    public @Test void test6() {
        System.out.println(articleDao.getPreviousArticleTypeID(5,1));
    }
    public @Test void test7() {
        System.out.println(articleDao.getArticle(1));
    }
    @Test
    public void test8() {
        Random random = new Random();
        for (int i=1;i<=12;i++) {
            for (int j=1;j<=28;j++) {
                int times = (int)(random.nextDouble() * 10);
                for (int k=1;k<=times;k++) {
                    Timestamp timestamp = Timestamp.valueOf("2018-"+i+"-"+j+" 00:00:00");
                    Consult consult = new Consult();
                    String phoneNumber = "1";
                    for (int l=1;l<=10;l++) {
                        phoneNumber += (int)(random.nextDouble() * 10);
                    }
                    consult.setPhoneNumber(phoneNumber);
                    consult.setName(getName());
                    consult.setApplyMethod((short)((random.nextDouble() * 9 + 1)));
                    consult.setState(0);
                    consult.setAcademy((int)(random.nextDouble() * 10));
                    consult.setCreateTime(timestamp);
                    consult.setLevel((short)(random.nextDouble() * 10));
                    consultDao.addConsult(consult);
                }
            }
        }
    }
    private String getName() {
        Random random = new Random();
        String[] Surname = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",
                "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎",
                "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷",
                "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和",
                "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒",
                "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季"};
        String girl = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
        String boy = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
        int index = random.nextInt(Surname.length - 1);
        String name = Surname[index]; //获得一个随机的姓氏
        int i = random.nextInt(3);//可以根据这个数设置产生的男女比例
        if(i==2){
            int j = random.nextInt(girl.length()-2);
            if (j % 2 == 0) {
                name = name + girl.substring(j, j + 2);
            } else {
                name = name + girl.substring(j, j + 1);
            }

        }
        else{
            int j = random.nextInt(girl.length()-2);
            if (j % 2 == 0) {
                name = name + boy.substring(j, j + 2);
            } else {
                name = name + boy.substring(j, j + 1);
            }

        }
        return name;
    }
}
