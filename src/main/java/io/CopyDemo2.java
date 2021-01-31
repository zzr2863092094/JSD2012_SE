package io;

import java.io.*;

/**
 * 使用缓冲流完成文件复制
 *
 * 缓冲流：java.io.BufferedInputStream和BufferedOutputStream
 * 他们是一对高级流，在流连接的作用是提高书写效率。
 *
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("driver.exe");
        BufferedInputStream bis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream("driver_cp.exe");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int d;
        long start = System.currentTimeMillis();
        while ((d = bis.read())!= -1) {
            bos.write(d);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕!耗时:" + (end - start) + "ms");
        bis.close();
        bos.close();

    }
}
