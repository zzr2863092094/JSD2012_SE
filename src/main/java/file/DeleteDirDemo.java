package file;

import java.io.File;

/**
 * 删除目录
 */
public class DeleteDirDemo {
    public static void main(String[] args) {
        //将当前目录下的demo目录删除
        File dir = new File("./demo");
        if(dir.exists()){
            //delete方法删除目录时必须是一个空目录才行
            dir.delete();
            System.out.println("目录以删除");
        }else{
            System.out.println("目录不存在");
        }
    }
}
