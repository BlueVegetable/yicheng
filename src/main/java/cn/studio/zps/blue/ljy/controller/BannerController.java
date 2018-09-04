package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.Banner;
import cn.studio.zps.blue.ljy.service.BannerService;
import cn.studio.zps.blue.ljy.utils.FileUpload;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Banner")
/**
 * @author 蔡荣镔
 */
public class BannerController {

    @Autowired
    private BannerService bannerService;
    /**
     * 文件路径
     */
    private static final String DIRECTORY="/banner-image";

    @ResponseBody
    @RequestMapping("upload")
    public Map uploadBanner(MultipartFile file) throws IOException {
        Map<String,Object> value = FileUpload.copyBanner(file);
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

    @RequestMapping("/addBanner")
    @ResponseBody
    public Map<String, Object> addBanner(@RequestBody Banner banner) {
        banner.setVisible(true);
        banner.setPosition(bannerService.getMaxPosition()+1);
        if(bannerService.addBanner(banner)){
            return Response.getResponseMap(0,"",null);
        } else {
            return Response.getResponseMap(1,"轮播图添加失败",null);
        }
    }

    @RequestMapping("/deleteBanner")
    public void deleteBanner(@RequestParam("id")int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Banner banner=bannerService.getBanner(id);
        if(bannerService.deleteBanner(id)) {
            //如果数据库成功就删除文件
            FileUpload.deleteBanner(banner.getPath());
            Response.writeString("1",response);
        }
        else
            Response.writeString("0",response);
    }

    @RequestMapping("/getBanners")
    @ResponseBody
    public Map getBanners(@RequestParam(value="visible",required=false) String visible) throws IOException {
        if(visible==null||!visible.equals("1")) visible="0";
        boolean visity=Integer.parseInt(visible)!=0;
        Map values=new HashMap<String,Object>(2);
        values.put("data",bannerService.getBanner(visity));
        values.put("number",bannerService.getCount(visity));
        return values;
    }

    @ResponseBody
    @RequestMapping("updateBanner")
    public Map updateBanner(@RequestBody Banner banner) {
        if(bannerService.updateBanner(banner))
            return Response.getResponseMap(0,"",null);
        else
            return Response.getResponseMap(1,"修改失败",null);
    }

    @RequestMapping("/updateState")
    public void updateState(@RequestParam(value="id")int id,@RequestParam("state")int visible,HttpServletResponse response) throws IOException {
        if(bannerService.alterVisible(id,visible==1))
            Response.writeString("1",response);
        else
            Response.writeString("0",response);
    }

    @RequestMapping("/upBanner")
    public void upBanner(@RequestParam("id") int current,HttpServletResponse response) throws IOException {
        int upId=bannerService.smaller(current);
        if(bannerService.exchange(current,upId))
            Response.writeString("1",response);
        else
            Response.writeString("0",response);
    }

    @RequestMapping("/downBanner")
    public void downBanner(@RequestParam("id")int current,HttpServletResponse response) throws IOException {
        int downId=bannerService.bigger(current);
        if(bannerService.exchange(current,downId))
            Response.writeString("1",response);
        else
            Response.writeString("0",response);
    }

}