package cn.studio.zps.blue.ljy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.nio.file.Paths;

public @Controller @RequestMapping("articleTest") class ArticleTestController {
    public @RequestMapping("test") @ResponseBody boolean test(@RequestParam("text") String text) throws IOException {
        File file = Paths.get("C:\\Users\\Administrator\\Desktop\\协议书.html").toFile();
        if(!file.exists())
            file.createNewFile();
        byte[] buffer = text.getBytes();
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(buffer);
        return true;
    }
}