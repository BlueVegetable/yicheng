package cn.studio.zps.blue.ljy.controller;


import cn.studio.zps.blue.ljy.domain.Admin;
import cn.studio.zps.blue.ljy.service.AdminService;
import cn.studio.zps.blue.ljy.utils.MD5;
import cn.studio.zps.blue.ljy.utils.Response;
import cn.studio.zps.blue.ljy.utils.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="admin")
public class AdminController {

    private Map<String, HttpSession> sessions = new HashMap<String,HttpSession>();

    private @Autowired AdminService adminService;
    private static final String KEY="123456";

    @RequestMapping("addAdmin")
    @ResponseBody
    public Map<String,Object> addAdmin(@RequestBody Admin admin) {
        if(adminService.addAdmin(admin)) {
            return Response.getResponseMap(0,"添加成功",null);
        } else {
            return Response.getResponseMap(1,"添加失败",null);
        }
    }

    @RequestMapping("deleteAdmin")
    @ResponseBody
    public Map deleteAdmin(@RequestParam("adminID") int adminID) {
        if(adminService.deleteAdmin(adminID)) {
            return Response.getResponseMap(0,"删除成功",null);
        } else {
            return Response.getResponseMap(1,"删除失败",null);
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpServletRequest request) {
        password= MD5.toMD5(password);
        Admin admin = adminService.login(userName,password);
        if(admin==null) {
            Map map=Response.getResponseMap(1,"账号与密码不相符",null);
            return map;
        }
        else {
            Map map=Response.getResponseMap(0,"",admin);
            String token= Token.createToken(admin);
            HttpSession session = request.getSession();
            session.setAttribute("token",token);
            sessions.put(token,session);
            map.put("token", token );
            return map;
        }
    }

    @RequestMapping("exit")
    @ResponseBody
    public Map<String,Object> exit(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("token");
        if(sessions.containsKey(token)) {
            session.invalidate();
            sessions.remove(token);
            return Response.getResponseMap(0,"退出成功",null);
        } else {
            return Response.getResponseMap(1,"用户未登录",null);
        }
    }

    @RequestMapping("getAdmins")
    @ResponseBody
    public Map<String,Object> getAdmins(@RequestParam(name = "limit", required = false) Integer limit,
                                        @RequestParam(name = "page", required = false) Integer page,
                                        @RequestParam(name="name",required = false) String name) {
        if(limit==null||page==null) {
            page=null;
            limit=null;
        } else {
            page=(page-1)*limit;
        }
        Map map = adminService.getAdmins(name,page,limit);
        map.put("code",0);
        map.put("msg","");
        return map;
    }

    @RequestMapping("updateAdmin")
    @ResponseBody
    public Map updateAdmin(@RequestBody Admin admin) {
        if(adminService.updateAdmin(admin)) {
            return Response.getResponseMap(0,"修改成功",null);
        } else {
            return Response.getResponseMap(1,"修改失败",null);
        }
    }

    @RequestMapping("resetPassword")
    @ResponseBody
    public Map resetPassword(@RequestParam("adminID")Integer adminID,@RequestParam("newPassword") String newPassword) {
        if(adminService.resetPassword(adminID,newPassword)) {
            return Response.getResponseMap(0,"修改成功",null);
        } else {
            return Response.getResponseMap(1,"修改失败",null);
        }
    }

}
