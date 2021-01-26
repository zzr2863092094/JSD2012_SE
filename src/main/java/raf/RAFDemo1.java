package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.RandomAccess;

/**
 * java.io.RandomAccessFile
 * RAF是专门来读写文件的类。其基于指针对文件进行随机读写。
 */
public class RAFDemo1 {
    public static void main(String[] args) throws IOException {
        //想对当前目录的raf.data文件进行操作
        /*
          RAF常用构造器
          RandomAccessFile(File file,String mode)
          RandomAccessFile(String path,String mode)
          第一个参数为什么要进行读写的文件，可以传入file对象也可以
          直接给定该文件的路径。
          第二个参数为操作模式，有两种：
          ”r“：只读模式，仅对该文件做读取数据操作
          ”rw":读写模式，对文件读写均可。
         */
        RandomAccessFile raf = new RandomAccessFile(
                "./raf.dat","rw"
        );
        //向文件中写入一个字节的2进制数据
        /*
           void write(ind d)
           向文件中写入1个字节，写入的是给定的int值所对应的2进制
           的“低八为”
           int型整数1的2进制：
           00000000 00000000 00000000 00000001

           write方法写入该int值对应2进制的低8位：
                                       vvvvvvvv
            00000000 00000000 00000000 00000001
         */
        raf.write(1);
        raf.write(2);// 00000000 00000000 00000000 00000010
        System.out.println("写出完毕");
        /*
           raf。dat文件数据内容：
           00000001 00000010
         */
        raf.close();//最终要调用close的方法！
    }
}
