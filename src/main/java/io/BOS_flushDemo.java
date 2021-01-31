package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用缓冲输出流写出数据的缓冲区问题
 */
public class BOS_flushDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("bos.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        String line = "让我再看你一眼，从南到北。";
        byte[] data = line.getBytes("UTF-8");
        bos.write(data);
        /*
           void flush()
           将缓冲流中已经缓存的数据一次性写出。
           频繁的调用flush会增加实际写出的次数，写出次数多则写效率差。
           但是可以提高书写数据的及时性。
         */
        bos.flush();
        System.out.println("写出完毕！");
        /*
           缓冲流的close方法中会执行一次flush
         */
        bos.close();
    }
}
