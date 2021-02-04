package thread;
//定义一个类SellTicket实现Runnable接口，里面定义一个成员变量：private int tickets = 100;
public class SellTicket implements Runnable {

    private static int tickets = 100; //票数
    // 在sellTicket类中重写run（）方法实现买票，代码步骤如下：
    private Object obj = new Object();

    @Override
    public void run() {
        //  A:判断票数大于0，就买票，并告知是哪个窗口卖的
        //  B:卖完了之后，总票数减1
        //  C:票没有了，可能还有人问，所以这里用死循环让卖票的动作一直执行
        while (true) {
            //t1=100
            //t2=100
            //t3 = 100
            synchronized (SellTicket.class) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                        //t1，等100毫秒
                        //t2，等100毫秒
                        //t3，等100毫秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //t1正在出售第100张票
                    //t2正在出售第100张票
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
                    // t3正在出售第100张票
                    tickets--;
                    //97
                }
            }
        }
    }

    private static synchronized void sellTicket() {

        if (tickets > 0) {
            try {
                Thread.sleep(100);
                //t1，等100毫秒
                //t2，等100毫秒
                //t3，等100毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //t1正在出售第100张票
            //t2正在出售第100张票
            System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
            // t3正在出售第100张票
            tickets--;
            //97
        }
    }
}