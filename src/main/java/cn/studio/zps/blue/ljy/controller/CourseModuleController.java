package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.Course;
import cn.studio.zps.blue.ljy.domain.CourseModule;
import cn.studio.zps.blue.ljy.domain.CourseType;
import cn.studio.zps.blue.ljy.service.CourseModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public @RequestMapping("courseModule") class CourseModuleController {
    private @Autowired CourseModuleService courseModuleService;
    public @RequestMapping("getCourseModuleByID") @ResponseBody CourseModule getCourseModuleByID(int moduleID) {
        CourseModule courseModule = courseModuleService.getCourseModuleByID(moduleID);;
        for (CourseType courseType:courseModule.getCourseTypes()) {
            for (Course course:courseType.getCourses()) {
                course.setVideoes(null);
            }
        }
        return courseModule;
    }
    @ResponseBody@RequestMapping("getAllCourseModules")
    public List<CourseModule> getAllCourseModules() {
        return courseModuleService.getAllCourseModules();
    }
}
