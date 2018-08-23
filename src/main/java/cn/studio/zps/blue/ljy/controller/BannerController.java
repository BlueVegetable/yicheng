package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.Banner;
import cn.studio.zps.blue.ljy.service.BannerService;
import cn.studio.zps.blue.ljy.utils.FileUpload;
import cn.studio.zps.blue.ljy.utils.Response;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @RequestMapping("/addBanner")
    public void addBanner(MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws IOException {
        String directory=request.getSession().getServletContext().getRealPath(DIRECTORY);
        String name= FileUpload.copy(file,directory);
        Banner banner=new Banner();
        banner.setPath(DIRECTORY+"/"+name);
        banner.setVisible(true);
        banner.setType(file.getContentType());
        bannerService.addBanner(banner);
        JSONObject json=new JSONObject();
        json.put("code",0);
        json.put("msg","");
        json.put("data",DIRECTORY+"/"+name);
        Response.sendJSONObject(json,response);
    }

    @RequestMapping("/deleteBanner")
    public void deleteBanner(@RequestParam("id")int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Banner banner=bannerService.getBanner(id);
        if(bannerService.deleteBanner(id)) {
            //如果数据库成功就删除文件
            String pathValue= request.getSession().getServletContext().getRealPath("");
            Path path=Paths.get(pathValue+banner.getPath());
            if(Files.exists(path))
                Files.delete(path);
            Response.writeString("1",response);
        }
        else
            Response.writeString("0",response);
    }

    @RequestMapping("/getBanners")
    @ResponseBody
    public Map getBanners(@RequestParam(value="visible",required=false) String visible, HttpServletResponse response) throws IOException {
        if(visible==null||!visible.equals("1")) visible="0";
        boolean visity=Integer.parseInt(visible)!=0;
        Map values=new HashMap<String,Object>(2);
        values.put("data",bannerService.getBanner(visity));
        values.put("number",bannerService.getCount(visity));
        return values;
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