package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件流完成文件复制操作
 */
public class CopyDemo {
    public static void main(String[] args) throws IOException {
        /*
           1：创建文件输入流读取源文件
           2：创建文件输出流写入复制文件
           3：循环快读写完成复制
           4：关闭两个流
         */
        FileInputStream fis = new FileInputStream("raf.drt");
        FileOutputStream fos = new FileOutputStream("raf_cp2.exe",true);
        int len;//记录每次块读数据后，实际读取到的字节数
        /*
            00000000  8位2进制 1byte 1字节
            1024byte  1kb
            1024kb    1mb
            1024mb    1gb
            1024gb    1tb
         */
        byte[] data = new byte[10];//10kb
        long start = System.currentTimeMillis();
        while((len = fis.read(data))!=-1){//读10kb
            fos.write(data,0,len);//读了多少字节就一次写多少字节
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕!耗时"+(end-start)+"ms");
        fis.close();
        fos.close();

    }
}


