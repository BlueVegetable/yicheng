package cn.studio.zps.blue.ljy.utils;

import com.alibaba.druid.support.json.JSONParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class RemoteURL {
    public Map getPhoneNumberInfo(String url, String phoneNumber, String...parameters) throws IOException {
        URL remoteURL=new URL(url);
        URLConnection connection=remoteURL.openConnection();

        connection.setConnectTimeout(5*1000);
        connection.setRequestProperty("connection","Keep-Alive");
        connection.setRequestProperty("Charset","UTF-8");
        connection.setDoOutput(true);
        connection.setDoInput(true);

        OutputStream outputStream=connection.getOutputStream();
        String parameterLine="shouji="+phoneNumber;
        for(String parameter:parameters){
            parameterLine+="&"+parameter;
        }
        outputStream.write(parameterLine.getBytes());

        InputStream inputStream=connection.getInputStream();
        StringBuffer sb=new StringBuffer();

        byte[] arr=new byte[1024];
        int len;

        while((len=inputStream.read(arr))>0) {
            sb.append(new String(arr,0,len,"utf-8"));
        }

        String resultLine=sb.toString();
        JSONParser jsonParser=new JSONParser(resultLine);
        return (Map)jsonParser.parseMap().get("result");
    }
}
