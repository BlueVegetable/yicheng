package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.Course;
import cn.studio.zps.blue.ljy.service.CourseService;
import cn.studio.zps.blue.ljy.utils.FileUpload;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * 文件路径
     */
    private static final String DIRECTORY="/course-image";

    @ResponseBody@RequestMapping("upload")
    public Map upload(MultipartFile file) {
        Map<String,Object> value = FileUpload.copyPicture(file,DIRECTORY);
        String name = (String) value.get("fileName");
        String msg = value.get("code").equals("SUCCESS")?"":"上传失败";
        int code = value.get("code").equals("SUCCESS")?0:1;

        Map<String,Object> data = new HashMap<>(2);
        data.put("path",DIRECTORY+"/"+name);
        data.put("type", value.get("fileType"));

        Map<String,Object> result = new HashMap<>(3);
        result.put("code",code);
        result.put("msg",msg);
        result.put("data",data);
        return result;
    }

    @ResponseBody@RequestMapping("addCourse")
    public Map addCourse(@RequestBody Course course) {
        if(courseService.addCourse(course)) {
            return Response.getResponseMap(0,"",null);
        } else {
            return Response.getResponseMap(1,"添加失败",null);
        }
    }

    @ResponseBody@RequestMapping("getCourseByID")
    public Map getCourseByID(int courseID) {
        Course course = courseService.getCourseByID(courseID);
        if(course == null) {
            return Response.getResponseMap(1,"无数据",null);
        } else {
            return Response.getResponseMap(0,"",course);
        }
    }
    @ResponseBody@RequestMapping("getCoursesByCourseTypeID")
    public List<Course> getCoursesByCourseTypeID(int courseTypeID) {
        return courseService.getCourseByCourseTypeID(courseTypeID);
    }
    @ResponseBody@RequestMapping("getAllCourses")
    public Map getAllCourses() {
        return Response.getResponseMap(0,"",courseService.getAllCourses());
    }
    @ResponseBody@RequestMapping("updateCourse")
    public Map updateCourse(@RequestBody Course course) {
        if(courseService.updateCourse(course)) {
            return Response.getResponseMap(0,"",null);
        } else {
            return Response.getResponseMap(1,"修改失败",null);
        }
    }
}
