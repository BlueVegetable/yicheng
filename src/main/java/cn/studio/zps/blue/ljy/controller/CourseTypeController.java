package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.CourseType;
import cn.studio.zps.blue.ljy.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public @RequestMapping("courseType") class CourseTypeController {
    private @Autowired CourseTypeService courseTypeService;
    public @RequestMapping("getCourseTypeByCourseID") @ResponseBody CourseType getCourseTypeByCourseID(int courseID) {
        CourseType courseType = courseTypeService.getCourseTypeByCourseID(courseID);
        return courseType;
    }
    @ResponseBody@RequestMapping("getCourseTypesByCourseModuleID")
    public List<CourseType> getCourseTypesByCourseModuleID(int courseModuleID) {
        return courseTypeService.getCourseTypesByCourseModuleID(courseModuleID);
    }
}
