package thread;

/**
 * 互斥锁
 * 当使用synchronized锁定多个代码片段，并且这些同步块指定的同步监视器对象相同时
 * 这些代码之间就是互斥的，多个线程不能同时执行他们。
 */
public class SyncDemo {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Thread t1 = new Thread(){
            public void run(){
                foo.methodA();
            }
        };
        Thread t2 = new Thread(){
            public  void run(){
                foo.methodB();
            }
        };
        t1.start();
        t2.start();
    }
}
class Foo {
    public synchronized void methodA() {

        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + ":正在执行A方法...");
            Thread.sleep(5000);
            System.out.println(t.getName() + ":执行A方法完毕！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //public synchronized void methodB(){
    public void methodB() {
        synchronized (this) {
            try {
                Thread t = Thread.currentThread();
                System.out.println(t.getName() + ":正在执行B方法...");
                Thread.sleep(5000);
                System.out.println(t.getName() + ":执行B方法完毕！");
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }
}