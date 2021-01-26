package file;


import java.io.File;
import java.sql.SQLOutput;

/* java.io.F.le可以表示硬盘上的一个文件或目录
 * 使用File可以：
 * 1：访问该文件或目录的属性信息（大小，修改日期，可读可写等）
 * 2：创建或删除文件目录
 *:3访问一个目录中的所有子项
 *
 *但是 File不能访问文件中的数据。
 */
public class FileDemo {
     public static void main(String[] args) {
         /*File创建时可以指定路径
         该路径通常使用相对路径，他有更好的跨平台性。

         相对路径中“./"表示当前目录，当前目录具体是那里要视
          当前程序的运行环境而定。在idea或eclipse里运行时，
            当前目录就是这个程序所在的项目目录。

          */
         File file = new File("./demo.txt");
         String name = file.getName();
         System.out.println(name);

         long len = file.length();
         System.out.println(len+"字节");

         boolean cr = file.canRead();
         System.out.println("可读："+cr);
         boolean cw = file.canWrite();
         System.out.println("可写："+cw);
         boolean ih = file.isHidden();
         System.out.println("是否隐藏："+ih);
     }
}
