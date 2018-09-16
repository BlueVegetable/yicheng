package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.Consult;
import cn.studio.zps.blue.ljy.service.ConsultService;
import cn.studio.zps.blue.ljy.utils.RemoteURL;
import cn.studio.zps.blue.ljy.utils.Response;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/Consult")
public class ConsultController {

    @Autowired
    private ConsultService consultService;
    /**
     * 此常量为获取手机号码的归属地必须传递的参数
     */
    private static final String PARAMETER="appkey=1d447a09ea953c29d4e9141b49c369d3";
    private static final String URL="https://way.jd.com/jisuapi/query4";

    /**
     * 四种报名方式所代表的常量：简单报名，普通报名，开放大学报名，入户报名
     */
    private static final Short SIMPLE_CONSULT = 0;
    private static final Short CONSULT = 0;
    private static final Short COLLEGE_CONSULT = 2;
    private static final Short RESIDENCE_CONSULT = 3;

    @RequestMapping(value="/addConsultSimple",method = RequestMethod.POST)
    public @ResponseBody Map addConsultSmiple(@RequestBody Consult consult) {

        if(consult.getApplyMethod()==null){
            consult.setApplyMethod(SIMPLE_CONSULT);
        }
        Map<String,Object> phoneNumberInfo;
        Map<String,Object> result = Response.getResponseMap(0,"添加成功",null);
        try{
            phoneNumberInfo=new RemoteURL().getPhoneNumberInfo(URL,consult.getPhoneNumber(),PARAMETER);
            if(phoneNumberInfo==null) {
                phoneNumberInfo=new LinkedHashMap<>();
                phoneNumberInfo.put("status","202");
                result.replace("code",2);
                result.replace("msg","查询号码归属地出错");
            }
        } catch(Exception e) {
            phoneNumberInfo=new LinkedHashMap<>();
            phoneNumberInfo.put("status","202");
            result.replace("code",2);
            result.replace("msg","手机号码存在问题");
            e.printStackTrace();
        }

        //设置Consult中的一个字段attribution
        if(phoneNumberInfo.get("status").equals("202")
                ||((Map)phoneNumberInfo.get("result")).get("province").equals("")
                ||((Map)phoneNumberInfo.get("result")).get("city").equals("")) {
            consult.setAttribution("未知");
        }
        else {
            Map<String,String> values=(Map)phoneNumberInfo.get("result");
            consult.setAttribution(values.get("province")+"省"+values.get("city")+"市");
        }

        //设置consult的状态和创造时间
        consult.setState(0);
        consult.setCreateTime(new Timestamp(System.currentTimeMillis()));

        if(!consultService.addConsult(consult)){
            result.replace("code",1);
            result.replace("msg","添加失败");
        }
        return result;
    }

    @RequestMapping(value="/addConsult",method = RequestMethod.POST)
    public @ResponseBody Map addConsult(@RequestBody Consult consult) {
        consult.setApplyMethod(CONSULT);
        return addConsultSmiple(consult);
    }

    @RequestMapping(value = "addCollegeConsult",method = RequestMethod.POST)
    public @ResponseBody Map addCollegeConsult(@RequestBody Consult consult) {
        consult.setApplyMethod(COLLEGE_CONSULT);
        return addConsultSmiple(consult);
    }

    @RequestMapping(value = "addResidenceConsult",method = RequestMethod.POST)
    public @ResponseBody Map addResidenceConsult(@RequestBody Consult consult) {
        consult.setApplyMethod(RESIDENCE_CONSULT);
        return addConsultSmiple(consult);
    }

    @RequestMapping("/deleteConsult")
    public void deleteConsult(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        if(consultService.deleteConsult(id)) {
            success(response);
        }
        else {
            fail(response);
        }
    }

    @RequestMapping("/getConsults")
    @ResponseBody
    public Map getConsults(int page,int limit,short applyMethod) throws IOException {
        List<Consult> consults=consultService.getConsults(page,limit,applyMethod);
        Map map = Response.getResponseMap(0,"",consults);
        map.put("count",consultService.getAllCount(applyMethod));
        return map;
    }

    @RequestMapping("/getConsultsLimit")
    @ResponseBody
    public Map getConsultsLimit(HttpServletRequest request,@RequestParam("applyMethod")Short applyMethod) {
        Integer id=null;
        int page=Integer.parseInt(request.getParameter("page"));
        int limit=Integer.parseInt(request.getParameter("limit"));
        if(request.getParameter("id")!=null&&isInteger(request.getParameter("id"))) {
            id = Integer.parseInt(request.getParameter("id"));
        }
        String name=request.getParameter("name");
        String remark=request.getParameter("remark");
        String phoneNumber=request.getParameter("phoneNumber");
        String createTime=request.getParameter("createTime");

        if(name!=null&&name.equals(""))
            name=null;
        if(remark!=null&&remark.equals(""))
            remark=null;
        if(phoneNumber!=null&&phoneNumber.equals(""))
            phoneNumber=null;
        if(createTime!=null&&createTime.equals(""))
            createTime=null;

        int start=(page-1)*limit;
        Map<String,Object>map=new LinkedHashMap<>();

        map.put("id",id);
        map.put("name",name);
        map.put("remark",remark);
        map.put("phoneNumber",phoneNumber);
        map.put("start",start);
        map.put("number",limit);
        map.put("createTime",createTime);
        map.put("applyMethod",applyMethod);

        List<Consult> consults=consultService.selectConsults(map);

        Map responseMap = Response.getResponseMap(0,"",consults);
        responseMap.put("count",consultService.limitConsultCount(id,name,remark,phoneNumber,applyMethod));
        return responseMap;
    }

    @RequestMapping("/getConsultById")
    public void getConsultById(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        response.getWriter().println(JSONObject.fromObject(consultService.getConsultById(id)));
    }

    @RequestMapping("/updateConsult")
    public void updateConsult(Consult consult,HttpServletResponse response) throws IOException {
        if(consultService.updateConsult(consult))
            success(response);
        else
            fail(response);
    }

    @RequestMapping("/alterState")
    public void alterState(int id,int state,HttpServletResponse response) throws IOException {
        if(consultService.alterState(id,state))
            success(response);
        else
            fail(response);
    }

    @RequestMapping("countUnDealing")
    public @ResponseBody List<Map<String, Object>> countUnDealing() {
        return consultService.countByState();
    }

    /**
     * 获取得到数量在前n名的地址与数量
     */
//    public void getLimitNumberClassfy(int n,HttpServletResponse response) throws IOException {
//        Map<String,Long> values = consultService.classifyCount();
//        int count=0;
//        long temp=-1;
//        if(n>=values.size())
//            Response.sendJSONArray(values,response);
//    }

    private void success(HttpServletResponse response) throws IOException {
        response.getWriter().println(1);
    }

    private void fail(HttpServletResponse response) throws IOException {
        response.getWriter().println(0);
    }

    private boolean isInteger(String value) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]+$");
        return pattern.matcher(value).matches();
    }

}
