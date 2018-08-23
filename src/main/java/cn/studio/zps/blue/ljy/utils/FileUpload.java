package cn.studio.zps.blue.ljy.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUpload {
    /**
     * @param file 将要被复制的文件
     * @param directory 文件路径
     * @return 新文件的名称
     * @throws IOException
     */
    public static String copy(MultipartFile file, String directory) throws IOException {
        Path path=Paths.get(directory);
        if(!Files.exists(path))
            Files.createDirectory(path);
        String name=""+System.currentTimeMillis()+""+file.hashCode()+""+directory.hashCode()+""+path.hashCode();
        File fileTo=Paths.get(directory+"/"+name).toFile();
        Files.createFile(Paths.get(directory+"/"+name));
        new Thread(new MyThread(fileTo,file)).start();
        return name;
    }
}
class MyThread implements Runnable{

    private File fileTo;
    private MultipartFile fileOriginal;

    public MyThread(File fileTo,MultipartFile fileOriginal) {
        this.fileOriginal=fileOriginal;
        this.fileTo=fileTo;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        InputStream is=null;
        OutputStream os=null;
        try {
            is=fileOriginal.getInputStream();
            os=new FileOutputStream(fileTo);
            byte[]buffer=new byte[1024];
            int size;

            while((size=is.read(buffer, 0, 1024))>0) {
                os.write(buffer, 0, size);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if(os!=null)
                    os.close();
            } catch(IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(is!=null)
                        is.close();
                } catch(IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}