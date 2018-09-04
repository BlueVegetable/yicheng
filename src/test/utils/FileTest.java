package utils;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTest {

    @Test
    public void test1() throws IOException {
        Files.createDirectories(Paths.get("D:\\Application\\apache-tomcat-main\\upload\\ueditor\\image"));
    }

}
