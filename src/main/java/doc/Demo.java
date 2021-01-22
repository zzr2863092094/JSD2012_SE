package doc;

/**
 * 文档注释只用在三个地方：类上，方法上，和常量上。
 * 文档注释是功能级注释，在类上使用时是用来说明当前类的设计意图和整体功能。
 * @author 周宗仁
 */
public class Demo {

    public  static  final  String INFO = "你好!";

    /**
     * 为指定的用户添加一个问候语
     * @param name  指定的用户的名字
     * @return   含有问候语的字符串
     */
    public String sayHello(String name){
        return "你好！"+name;
    }
}
