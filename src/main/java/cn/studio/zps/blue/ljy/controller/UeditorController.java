package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.utils.FileUpload;
import cn.studio.zps.blue.ljy.utils.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Controller
@RequestMapping("ueditor")
public class UeditorController {

//    private final static String ROOT = "/";

    private final static String ROOT = "/standby/";

    @RequestMapping(value="/server")
    public void config(HttpServletRequest request, HttpServletResponse response,
                       @RequestParam("action") String action) throws ServletException, IOException {
        String url;
        switch (action) {
            case "uploadimage":url="./uploadimage.do";break;
            case "uploadscrawl":url=".uploadimage.do";break;
            case "uploadvideo":url="./uploadVideo.do";break;
            default :url=null;break;
        }
        if(url!=null) {
            request.getRequestDispatcher(url).forward(request,response);
            return ;
        }
        response.setContentType("application/json");
        String rootPath = request.getSession()
                .getServletContext().getRealPath(ROOT);

        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("uploadimage")
    @ResponseBody
    public Properties uploadimage(@RequestParam(value="upfile") MultipartFile file) {
        Map<String,Object> value = FileUpload.copyUeditorImage(file);
        Properties result = new Properties();
        result.put("state",value.get("code"));
        result.put("url",value.get("relativePath"));
        result.put("title",""+value.get("fileName"));
        result.put("original",value.get("fileName"));
        return result;
    }

    @RequestMapping("uploadVideo")
    @ResponseBody
    public Properties uploadVideo(@RequestParam(value="upfile") MultipartFile file) {
        Map<String,Object> value = FileUpload.copyUeditorVideo(file);
        Properties result = new Properties();
        result.put("state",value.get("code"));
        result.put("url",value.get("relativePath"));
        result.put("title",""+value.get("fileName"));
        result.put("original",value.get("fileName"));
        return result;
    }

    @RequestMapping("catchImage")
    @ResponseBody
    public Map<String,Object> catchImage(@RequestBody List<String> source) {
        Map<String,Object> result = new HashMap<>();
        result.put("state","SUCCESS");
        return result;
    }

}
