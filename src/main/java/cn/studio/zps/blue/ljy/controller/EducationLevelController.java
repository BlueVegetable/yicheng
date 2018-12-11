package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.EducationLevel;
import cn.studio.zps.blue.ljy.service.EducationLevelService;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller@RequestMapping("educationLevel")
public class EducationLevelController {
    public static final Byte OPEN = 1;
    public static final Byte CLOSE = 0;
    @Autowired
    private EducationLevelService educationLevelService;
    @ResponseBody@RequestMapping("addEducationLevel")
    public Map addEducationLevel(EducationLevel educationLevel) {
        educationLevel.setVisible(OPEN);
        if(educationLevelService.addEducationLevel(educationLevel)) {
            return Response.getResponseMap(0,"",null);
        } else {
            return Response.getResponseMap(1,"",null);
        }
    }
    @ResponseBody@RequestMapping("getEducationLevelByID")
    public Map getEducationLevelByID(@RequestParam("id")int id) {
        return Response.getResponseMap(0,"",educationLevelService.getEducationLevelByID(id));
    }
    @ResponseBody@RequestMapping("getEducationLevels")
    public List<EducationLevel> getEducationLevels() {
        return educationLevelService.getEducationLevels(OPEN);
    }
    @ResponseBody@RequestMapping("getEducationLevelsDeal")
    public Map getEducationLevelsDeal() {
        return Response.getResponseMap(0,"",educationLevelService.getEducationLevels(OPEN));
    }
    @ResponseBody@RequestMapping("updateEducationLevel")
    public boolean updateEducationLevel(EducationLevel educationLevel) {
        return educationLevelService.updateEducationLevel(educationLevel);
    }
}
