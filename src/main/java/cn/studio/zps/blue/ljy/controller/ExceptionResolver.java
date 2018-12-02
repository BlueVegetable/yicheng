package cn.studio.zps.blue.ljy.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        Map result = new LinkedHashMap(2);
        String msg = "";
        result.put("code",1);
        //设置状态码
        response.setStatus(HttpStatus.OK.value());
        //设置ContentType
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        //避免乱码
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        if (ex instanceof SQLException) {
            msg = "数据库访问出错";
        } else {
            msg = "服务器发生错误";
        }
        result.put("msg",msg);
        try {
            response.getWriter().println(JSONObject.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}