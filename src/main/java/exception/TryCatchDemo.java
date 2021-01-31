package exception;

/**
 * 异常处理机制中的Try-catch
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
        try {/*try语句块用来扩上可能出错的代码片段*/
            String str = "abc";
            /* String str="";*/
            /*  String str = null;*/
        /*
          如果str为null时，当虚拟机执行到下面的代码会发现这里存在空指针现象，
          于是虚拟机会实例化一个空指针异常的实例，并将其抛出。抛出后会检查报
          错的点这句话是否被异常处理机制控制，如果没有则会将该异常抛出到当前
          方法外面，由调用方法的代码
         */

            System.out.println(str.length());
            System.out.println(str.charAt(0));
            System.out.println(Integer.parseInt(str));
            System.out.println("!!!!!!!!");
           /*try语句中报错代码以下内容不会被执行！！！*/
        }catch(NullPointerException e) {
            /*catch用来捕获try中出现的指定异常并予以解决*/
            System.out.println("出现了空指针");
            /*catch可以定义多个，当try中不同异常有不同处理方式时可以分别捕获*/
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("字符串下标越界了");
           /*catch超类异常的意义：
             try中某几类异常希望使用相同处理办法时，可以catah这些
             异常的超类。
             在最后一个catch处捕获Exception也可以避免
            */
        }catch(Exception e){
            System.out.println("反正就是出了个错");
        }

        System.out.println("程序结束了");
    }
}
