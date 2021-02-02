package thread;

import java.sql.SQLOutput;

/**
 * 线程提供了一组相关的信息方法
 */
public class ThreadInfo {
    public static void main(String[] args) {
        //获取主线程
        Thread t = Thread.currentThread();
        //获取线程名字
        String name = t.getName();
        System.out.println("name:" + name);
        //获取唯一标识
        long id = t.getId();
        System.out.println("唯一标识：" + id);
        //获取线程优先级
        int priority = t.getPriority();
        System.out.println("优先级：" + priority);
        //线程是否活着
        boolean isAlive = t.isAlive();
        System.out.println("isAlive"+isAlive);
        //线程是否守护线程
        boolean isDaemon = t.isDaemon();
        System.out.println("isDemo:"+isDaemon);
        //线程是否被中断了
        boolean isInterrupted = t.isInterrupted();
        System.out.println("isInterrupted"+isInterrupted);
    }
}





