package lambda;

import java.io.File;
import java.io.FileFilter;

public class LambdaDemo1 {
    public static void main(String[] args) {
        FileFilter filter = new FileFilter() {
            public boolean accept(File file) {
                return file.getName().contains("e");
            }

        };
        FileFilter filter1 = (File file) -> {
            return file.getName().contains("e");
        };
        FileFilter filter2 = (File file) -> {
            return file.getName().contains("e");
        };
        /*
        当方法当中只有一句代码，那么方法体的"{}"可以忽略不写
        并且该方法要求返回值，则return关键字也要一同忽略。
         */
        FileFilter filter3 = (file)->file.getName().contains("e");
    }
}