package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.utils.FileUpload;
import cn.studio.zps.blue.ljy.utils.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@Controller
@RequestMapping("ueditor")
public class UeditorController {

    @RequestMapping(value="/server")
    public void config(HttpServletRequest request, HttpServletResponse response,
                       @RequestParam("action") String action,
                       @RequestParam(value="upfile",required = false) MultipartFile file) throws ServletException, IOException {

        String url;
        switch (action) {
            case "uploadimage":url="./uploadimage.do";break;
            default :url=null;break;
        }
        if(url!=null) {
            request.getRequestDispatcher(url).forward(request,response);
            return ;
        }
        response.setContentType("application/json");
        String rootPath = request.getSession()
                .getServletContext().getRealPath("/");

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
    public Properties uploadimage(HttpServletRequest request, HttpServletResponse response,
                                  @RequestParam(value="upfile",required = false) MultipartFile file) throws IOException {
        System.out.println(file);
        System.out.println(request.getServletContext().getRealPath(""));
        FileUpload.copyFile(file);
        Properties result = new Properties();
        result.put("state","SUCCESS");
        result.put("url","/upload/"+file.hashCode());
        result.put("title",""+file.hashCode());
        result.put("original",""+file.hashCode());
        return result;
    }

}
