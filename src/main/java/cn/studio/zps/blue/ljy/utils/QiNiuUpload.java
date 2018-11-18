package cn.studio.zps.blue.ljy.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.processing.OperationManager;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UpCompletionHandler;
import com.qiniu.storage.UploadManager;
import com.qiniu.http.Response;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.Mac;
import java.io.File;

public class QiNiuUpload {
    private static final String ACCESS_KEY = "mUpwbR-FgM0Pn6MiBCZ-Cmp2ZywoCBERopgWdyoN";
    private static final String SECRET_KEY = "LXC0wQwSnRzJHzI0jQqBYXTzYO2p7OURxvStmDic";
    public static final String BUCKET_NAME = "vegetablefarm";
    private static final String URL = "http://phv3m678m.bkt.clouddn.com/";
    private static UploadManager uploadManager = new UploadManager(new Configuration(Zone.autoZone()));
    private static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    /**
     * 执行操作的管理对象
     */
    private static OperationManager operationMgr = new OperationManager(auth, new Configuration(Zone.zone0()));

    public static String simpleFileUpload(String filePath) {
        String fileName = fileUpload(filePath);
        return URL + fileName;
    }
    public static String uploadVideo(String filePath) {
        String fileName = fileUpload(filePath);
        if(fileName == null) {
            return null;
        }
        fileName = transcoding(fileName);
        return URL + fileName;
    }
    public static String transcoding(String originName) {
        String newName = originName + originName.hashCode();
        //处理队列
        String pipeline = "admin_merge_radio";
        //saveas接口 参数
        String saveAs = UrlSafeBase64.encodeToString(BUCKET_NAME + ":" + newName);
        //处理命令 avthumb 和 saveas 通过管道符 |  进行连接
        String fops = "avthumb/mp4/vcodec/libx264|saveas/" + saveAs;
        try {
            //执行转码和另存 操作
            String persistentId = operationMgr.pfop(BUCKET_NAME, originName, fops, new StringMap().put("persistentPipeline", pipeline));
            System.out.println(persistentId);
            delete(originName);
            return newName;
        } catch (QiniuException e) {
            String errorCode = String.valueOf(e.response.statusCode);
            System.out.println(errorCode);
            e.printStackTrace();
        }
        return null;
    }
    public static boolean delete(String fileName) {
        Zone z = Zone.zone0();
        Configuration c = new Configuration(z);
        // 实例化一个BucketManager对象
        BucketManager bucketManager = new BucketManager(auth, c);
        try {
            // 调用delete方法移动文件
            bucketManager.delete(BUCKET_NAME, fileName);
            return true;
        } catch (QiniuException e) {
            // 捕获异常信息
            Response r = e.response;
            System.out.println(r);
            return false;
        }
    }
    private static String fileUpload(String filePath){
        String upToken = auth.uploadToken(BUCKET_NAME);
        String key  = null;
        try {
            Response response = uploadManager.put(filePath, key, upToken);
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
            return putRet.key;
        }catch (QiniuException ex){
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                // ignore
            }
        }
        return null;
    }
}
