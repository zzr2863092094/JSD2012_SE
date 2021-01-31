package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *使用转换流读取文本数据
 */
public class ISRDemo {
    public static void main(String[] args) throws IOException {


        FileInputStream fis = new FileInputStream("osw.txt");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        int d;
        /*
            int read()
            字符流的read()方法是读取一个字符，返回的是一个"char"
            但实际是用int型返回，因此该int值对应的2进制是"低16位"
            有效。如果int返回值为-1则表示文件末尾。
         */
        while ((d = isr.read()) != -1) {
            System.out.println((char) d);
        }
        isr.close();
    }
}