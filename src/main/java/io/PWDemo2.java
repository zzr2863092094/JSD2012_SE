package io;

import javax.imageio.stream.ImageInputStream;
import java.io.*;

/**
 *使用流连接形式创建PW完成文本数据的写出操作
 */
public class PWDemo2 {
    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("pw2.txt");
        /*
            高级流，转换流
            1:负责衔接字符流与字节流
            2:负责将写出的字符按照指定的字符集转换为字节
         */
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter bw = new BufferedWriter(osw);
        PrintWriter pw = new PrintWriter(bw);
        pw.println("和我在成都的街头走一走");
        pw.println("直到所有的灯都熄灭了，也不停留");
        System.out.println("写出完毕");
        pw.close();
    }
}
