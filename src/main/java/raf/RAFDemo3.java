package raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 使用RAF读写基本类型数据，以及RAF指针操作
 */

public class RAFDemo3 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("raf.dat","rw");
        long pos  = raf.getFilePointer();
        System.out.println("pos:"+pos);
    /*

     */
        int imax = Integer.MAX_VALUE;
        raf.write(imax>>>24);
        System.out.println("pos:"+raf.getFilePointer());
        raf.write(imax>>>16);
        raf.write(imax>>>8);
        raf.write(imax);
        System.out.println("pos:"+raf.getFilePointer());

        raf.writeInt(imax);
        System.out.println("pos:"+raf.getFilePointer());
        raf.writeLong(123L);
        System.out.println("pos:"+raf.getFilePointer());
        raf.writeDouble(123.123);
        System.out.println("pos:"+raf.getFilePointer());
        System.out.println("写出完毕");

        raf.seek(0);
        System.out.println("pos:"+raf.getFilePointer());
        //读取int值
        int d = raf.read();
        System.out.println(d);
        System.out.println("pos:"+raf.getFilePointer());
        //读取long值
        raf.seek(8);
        long l = raf.readLong();
        System.out.println(l);
        System.out.println("pos:"+raf.getFilePointer());//16
        //读取double值
        double dou = raf.readDouble();
        System.out.println(dou);
        System.out.println("pos:"+raf.getFilePointer());//24

        //修改raf.dat文件中long所在位置的值改为456
        //1将指针移动到long值来覆盖原有数据
        raf.seek(8);
        raf.writeLong(456);

        raf.seek(8);
        l = raf.readLong();
        System.out.println(l);
        raf.close();
    }
}
