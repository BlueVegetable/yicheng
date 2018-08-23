package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.Consult;
import cn.studio.zps.blue.ljy.service.ConsultService;
import cn.studio.zps.blue.ljy.utils.RemoteURL;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value="/addConsult",method = RequestMethod.POST)
    public void addConsult(Consult consult, HttpServletResponse response) throws IOException {
        Map<String,Object> phoneNumberInfo=new RemoteURL().getPhoneNumberInfo(URL,consult.getPhoneNumber(),PARAMETER);

        //设置Consult中的一个字段attribution
        if(phoneNumberInfo.get("status").equals("202"))
            consult.setAttribution("");
        else {
            Map<String,String> values=(Map)phoneNumberInfo.get("result");
            consult.setAttribution(values.get("province")+"省"+values.get("city")+"市");
        }

        //设置consult的状态和创造时间
        consult.setState(0);
        consult.setCreateTime(new Timestamp(System.currentTimeMillis()));

        if(consultService.addConsult(consult))
            response.getWriter().println(1);
        else
            response.getWriter().println(0);
    }

    @RequestMapping("/deleteConsult")
    public void deleteConsult(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        if(consultService.deleteConsult(id))
            success(response);
        else
            fail(response);
    }

    @RequestMapping("/getConsults")
    public void getConsults(int page,int limit,HttpServletResponse response) throws IOException {
        List<Consult> consults=consultService.getConsults(page,limit);
        JSONObject json=new JSONObject();
        json.put("code",0);
        json.put("count",consultService.getAllCount());
        json.put("msg","");
        json.put("data",consults);
        response.getWriter().println(json);
    }

    @RequestMapping("/getConsultsLimit")
    public void getConsultsLimit(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Integer id=null;
        int page=Integer.parseInt(request.getParameter("page"));
        int limit=Integer.parseInt(request.getParameter("limit"));
        if(request.getParameter("id")!=null&&isInteger(request.getParameter("id")))
            id=Integer.parseInt(request.getParameter("id"));
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

        List<Consult> consults=consultService.selectConsults(map);

        JSONObject json=new JSONObject();
        json.put("code",0);
        json.put("count",consultService.limitConsultCount(id,name,remark,phoneNumber));
        json.put("msg","");
        json.put("data",consults);
        response.getWriter().println(json);
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
