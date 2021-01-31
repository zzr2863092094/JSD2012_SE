package exception;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 当子类重写超类中含有throws声明异常抛出的方法时，对throws的重写规则
 */
public class ThrowsDemo {
    private  void dosome()throws IOException, AWTException {}
}
class SubClass extends  ThrowsDemo{
    /*public void domose()throws IOException,AWTException{}*/
    /*允许不在抛出任何异常
    /*public void dosome(){}
    /*允许仅抛出部分异常
    /*public void dosome()throws IOException{}
    /*允许抛出超类方法抛出异常的子类异常
     private void dosome()throws FileNotFoundException{}
     /*
     不允许抛出额外异常，超类方法没有的，也没有继承关系的异常
     public void dosome()throws SQLException{}
     不允许抛出抛出超类方法抛出异常的超类型异常
     private void dosome()throws Exception{}
     */

}
