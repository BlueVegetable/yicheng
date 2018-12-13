package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.Course;
import cn.studio.zps.blue.ljy.service.CourseService;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @ResponseBody@RequestMapping("getCourseByID")
    public Map getCourseByID(int courseID) {
        Course course = courseService.getCourseByID(courseID);
        if(course == null) {
            return Response.getResponseMap(1,"无数据",null);
        } else {
            return Response.getResponseMap(0,"",course);
        }
    }
    @ResponseBody@RequestMapping("getCourseByCourseTypeID")
    public List<Course> getCourseByCourseTypeID(int courseTypeID) {
        return courseService.getCourseByCourseTypeID(courseTypeID);
    }
}
