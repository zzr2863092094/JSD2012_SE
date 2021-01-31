package exception;

import java.sql.SQLOutput;

/**
 * 异常常见的方法
 */
public class ExceptionApiDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了...");

        try {
            String str = "abc";
            System.out.println(Integer.parseInt(str));
        } catch (Exception e) {
            /*向控制台输出异常信息*/
            e.printStackTrace();
            /*获取错误信息，通常给用户提示或记录日志的额时候
            会使用到它。
             */
            String message = e.getMessage();
            System.out.println(message);
        }

        System.out.println("程序结束了...");
    }
}
