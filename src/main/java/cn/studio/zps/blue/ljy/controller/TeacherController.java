package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.Teacher;
import cn.studio.zps.blue.ljy.service.TeacherService;
import cn.studio.zps.blue.ljy.utils.FileUpload;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    private static final String DIRECTORY = "/teacher-image";

    @RequestMapping("upload")
    @ResponseBody
    public Map uploadTeacherImg(MultipartFile file){
        Map<String,Object> value = FileUpload.copyTeacherImg(file);
        String name = (String) value.get("fileName");
        String msg = value.get("code").equals("SUCCESS")?"":"上传失败";
        int code = value.get("code").equals("SUCCESS")?0:1;

        Map<String,Object> data = new HashMap<>(2);
        data.put("path",DIRECTORY + "/" + name);
        data.put("type",value.get("fileType"));

        Map<String,Object> result = new HashMap<>(3);
        result.put("code",code);
        result.put("msg",msg);
        result.put("data",data);
        return  result;
    }

    @RequestMapping("addTeacher")
    @ResponseBody
    public Map<String,Object> addTeacher(@RequestBody Teacher teacher){
        System.out.println(teacher);
        if(teacherService.addTeacher(teacher)){
            return Response.getResponseMap(0,"添加成功",null);
        }else{
            return Response.getResponseMap(1,"添加失败",null);
        }
    }
    /*
    这里是添加了一个搜索功能的，因为要查找老师，
     */
    @RequestMapping("getTeacher")
    @ResponseBody
    public Map getTeacher(@RequestParam(name = "limit",required = false) Integer limit ,
                          @RequestParam(name = "page" , required = false) Integer page,
                          @RequestParam(name = "name" , required = false) String name){
        if(limit==null||page==null) {
            page=null;
            limit=null;
        } else {
            page=(page-1)*limit;
        }
        Map map  = teacherService.getTeacher(name, page, limit);
        map.put("code",0);
        map.put("msg","");

        return map;
    }

    @RequestMapping("deleteTeacher")
    @ResponseBody
    public Map deleteTeacher(@RequestParam("teacherID") int teacherID){
        if(teacherService.deleteTeacher(teacherID)){
            return Response.getResponseMap(0,"删除成功",null);
        }else{
            return Response.getResponseMap(1,"删除失败",null);
        }
    }
    @RequestMapping("updateTeacher")
    @ResponseBody
    public Map updateTeacher(@RequestBody Teacher teacher){
        if(teacherService.updateTeacher(teacher)){
            return Response.getResponseMap(0,"更新成功",null);
        }else{
            return Response.getResponseMap(1,"更新失败",null);
        }
    }

    /*
    教师前端接口
     */
    @RequestMapping("getAllTeacher")
    @ResponseBody
    public List<Teacher> getAllTeacher(){
        return teacherService.getAllTeacher();
    }
}
