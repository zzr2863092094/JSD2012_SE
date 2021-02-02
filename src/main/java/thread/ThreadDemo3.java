package thread;

/**
 *使用匿名内部类的形式完成两种线程的创建
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread t1 = new Thread() {

            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("你是谁啊");
                }
            }

        };
        Runnable r2 = new MyRunnable2() {

            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("查水表的！");
                }
            }

        };
            Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

    }
}