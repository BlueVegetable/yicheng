package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.MajorCourse;
import cn.studio.zps.blue.ljy.service.MajorCourseService;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller@RequestMapping("majorCourse")
public class MajorCourseController {
    public static final byte OPEN = 1;
    public static final byte CLOSE = 0;
    @Autowired
    private MajorCourseService majorCourseService;
    @ResponseBody@RequestMapping("addMajorCourse")
    public Map<String,Object> addMajorCourse(MajorCourse majorCourse) {
        majorCourse.setVisible(OPEN);
        boolean result = majorCourseService.addMajorCourse(majorCourse);
        if(result)
            return Response.getResponseMap(0,"",null);
        else
            return Response.getResponseMap(1,"",null);
    }
    @ResponseBody@RequestMapping("getMajorCourseByID")
    public Map getMajorCourseByID(@RequestParam("id")int id) {
        MajorCourse majorCourse = majorCourseService.getMajorCourseByID(id);
        return Response.getResponseMap(0,"",majorCourse);
    }
    @ResponseBody@RequestMapping("getMajorCourses")
    public List<MajorCourse> getMajorCourses() {
        return majorCourseService.getMajorCourses(OPEN);
    }
    @ResponseBody@RequestMapping("getMajorCoursesDeal")
    public Map getMajorCoursesDeal() {
        return Response.getResponseMap(0,"",majorCourseService.getMajorCourses(CLOSE));
    }
    @ResponseBody@RequestMapping("updateMajorCourse")
    public boolean updateMajorCourse(MajorCourse majorCourse) {
        return majorCourseService.updateMajorCourse(majorCourse);
    }
}