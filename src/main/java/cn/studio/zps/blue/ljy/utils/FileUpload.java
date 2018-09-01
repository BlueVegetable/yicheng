package cn.studio.zps.blue.ljy.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileUpload {

    private final static int LENGTH=1024;
    private final static String DELETE_PATH = "D:\\Application\\apache-tomcat-main\\upload\\";
    private final static String PATH = DELETE_PATH + "banner-image\\";

    /**
     * @param file 将要被复制的文件
     * @return 新文件的名称
     * @throws IOException
     */
    public static Map<String,Object> copyFile(MultipartFile file) {
        String fileName = System.currentTimeMillis()+"-"+file.hashCode()+"-"+Math.random();
        String filePath = PATH+fileName;
        String type = file.getContentType();
        String code = "SUCCESS";

        InputStream is = null;
        OutputStream os = null;
        try {
            is = file.getInputStream();
            os = new FileOutputStream(Paths.get(filePath).toFile());
            byte[] buffer = new byte[LENGTH];
            int size;
            while((size=is.read(buffer,0,LENGTH))>0) {
                os.write(buffer,0,size);
            }
        } catch (IOException e) {
            code = "FAILED";
            e.printStackTrace();
        } finally {
            try {
                if(os!=null) {
                    os.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }

        Map<String,Object> result = new HashMap<>(4);
        result.put("code",code);
        result.put("fileName",fileName);
        result.put("filePath",filePath);
        result.put("fileType",type);
        return result;
    }

    public static void deleteFile(String filePath) {
        Path path = Paths.get(DELETE_PATH + filePath);
        if(Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}