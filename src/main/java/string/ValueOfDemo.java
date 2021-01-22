package string;

/**
 * static String
 *
 */
public class ValueOfDemo {
    public static void main(String[] args) {
        int i = 123;
        String str = String.valueOf(i);
        System.out.println(str);

        double dou = 123.123;
        String str2 = String.valueOf(dou);
        System.out.println(str2);

        String s3 = i  + "";//任何内容与字符串连接结果都是字符串
        System.out.println(s3);
}
}
