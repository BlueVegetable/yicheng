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
import java.util.Random;

public class FileUpload {

    private final static int LENGTH=10240;
    private static final Random RANDOM = new Random();
    //本地主服务器的路径
//    private final static String PATH = "D:/Application/apache-tomcat-main/upload";
    //阿里云服务器路径
    private final static String PATH = "C:/servers/apache-tomcat3/upload";
//    private final static String PATH = "C:/rongbin-tomcat/apache-tomcat-main/upload";
//    private final static String PATH = "E:/服务器目录/apache-tomcat-first/upload";
//    private final static String PATH = "D:/tomcat/apache-tomcat-8.0.0/upload";
    private final static String BANNER_PATH = "/banner-image/";
    private final static String BANNER_PC_PATH = "/banner-pc-image/";
    private final static String HOME_PAGE_PICTURE_PATH = "/homePagePicture/";
    private final static String UEDITOR_IMAGE_PATH = "/ueditor/image/";
    private final static String UEDITOR_VIDEO_PATH = "/ueditor/video/";
    private final static String TEACHER_IMAGE_PATH = "/teacher-image/";
    private final static String MODULE_PICTURE_PATH = "/modulePicture/";
    private final static String ARTICLE_TYPE_PICTURE_PATH = "/articleTypePicture/";

    public static Map<String,Object> copyFile(MultipartFile file,String path) {
        String type = file.getContentType();
        String typeValue = type.substring(type.lastIndexOf('/')+1);
        String fileName = System.currentTimeMillis()+""+file.hashCode()+""+RANDOM.nextLong() + "";
        String filePath = path+fileName;
        String code = "SUCCESS";

        InputStream is = null;
        OutputStream os = null;
        try {
            if(!Files.exists(Paths.get(path))) {
                Files.createDirectories(Paths.get(path));
            }
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

    public static Map<String,Object> copyBanner(MultipartFile file) {
        Map<String,Object> result = copyFile(file,PATH + BANNER_PATH);
        result.put("relativePath" , BANNER_PATH);
        return result;
    }

    public static Map<String,Object> copyBannerPC(MultipartFile file) {
        Map<String,Object> result = copyFile(file,PATH + BANNER_PC_PATH);
        result.put("relativePath" , BANNER_PC_PATH + result.get("fileName"));
        return result;
    }

    public static Map<String,Object> copyHomePagePicture(MultipartFile file) {
        Map<String,Object> result = copyFile(file,PATH + HOME_PAGE_PICTURE_PATH);
        result.put("relativePath" , HOME_PAGE_PICTURE_PATH + result.get("fileName"));
        return result;
    }

    public static Map<String,Object> copyModulePicture(MultipartFile file) {
        Map<String,Object> result = copyFile(file,PATH + MODULE_PICTURE_PATH);
        result.put("relativePath" , MODULE_PICTURE_PATH + result.get("fileName"));
        return result;
    }

    public static Map<String,Object> copyArticleTypePicture(MultipartFile file) {
        Map<String,Object> result = copyFile(file,PATH + ARTICLE_TYPE_PICTURE_PATH);
        result.put("relativePath" , ARTICLE_TYPE_PICTURE_PATH + result.get("fileName"));
        return result;
    }

    public static Map<String,Object> copyUeditorImage(MultipartFile file) {
        Map<String,Object> result = copyFile(file,PATH + UEDITOR_IMAGE_PATH);
        result.put("relativePath",UEDITOR_IMAGE_PATH + result.get("fileName"));
        return result;
    }

    public static Map<String,Object> copyUeditorVideo(MultipartFile file) {
        Map<String,Object> result = copyFile(file,PATH + UEDITOR_VIDEO_PATH);
        result.put("relativePath",UEDITOR_VIDEO_PATH + result.get("fileName"));
        return result;
    }

    public static Map<String,Object> copyTeacherImg(MultipartFile file){
        Map<String,Object> result = copyFile(file,PATH + TEACHER_IMAGE_PATH);
        result.put("relativePath",TEACHER_IMAGE_PATH + result.get("file Name"));
        return  result;
    }

    public static void deleteFile(String deletePath, String filePath) {
        Path path = Paths.get(deletePath + filePath);
        if(Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteBanner(String relativePath) {
        deleteFile(PATH,relativePath);
    }

    public static void deleteHomePagePicture(String relativePath) {
        deleteFile(PATH,relativePath);
    }

    public static void deleteModulePicture(String relativePath) {
        deleteFile(PATH,relativePath);
    }

    public static void deleteArticleTypePicture(String relativePath) {
        deleteFile(PATH,relativePath);
    }

    public static void deleteUeditorImage(String ueditorImageName) {
        deleteFile(PATH + UEDITOR_IMAGE_PATH,ueditorImageName);
    }

    public static void deleteUeditorVideo(String ueditorVideoName) {
        deleteFile(PATH + UEDITOR_VIDEO_PATH,ueditorVideoName);
    }

    public static void deleteTeacherImg(String relativePath){
        deleteFile(PATH,relativePath);
    }

}