package string;
/**
 * String的优化导致其为不变对象，这会存在利于重用但是不利于修改操作。
 * 频繁修改String会降低性能并有较多的系统开销。
 *
 * java.lang.StringBuilder是专门设计用来修改String的API，其内部维护
 * 一个可变的char数组，并提供了多种修改字符串内容的方法，例如：增删改插，和
 * String原有的相关方法:indexOf,length等等。
 * StringBuilder修改String内容速度快，开销小。
 */
public class StingBuilderDemo {
    public static void main(String[] args) {
        String str = "好好学习java";
        //StringBuilder  builder = new StringBuilder();
        // StringBuilder  builder = new StringBuilder(str);
        StringBuffer builder = new StringBuffer(str);
        /*好好学习java

         */
        builder.append(",就是为了找个好工作!");
        str = builder.toString();
        System.out.println(str);


        builder.replace(13,18,"改变世界");
        // System.out.println(builder.toString());
        System.out.println(builder);

        builder.delete(0,8);
        System.out.println(builder);

        /*,就是为了改变世界！
        活着,就是为了改变世界！
        insert:将给定内容插入到指定位置
         */
        builder.insert(0,"活着");
        System.out.println(builder);

        builder.reverse();
        System.out.println(builder);
    }
}
