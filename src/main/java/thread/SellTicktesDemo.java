package thread;
/*
    需求：
        某电影院目前正在上映国产大片，共有100张票，它有3个窗口买票，请设计一个程序模拟改电影院买票
    思路：
        1：定义一个类SellTicket实现Runnable接口，里面定义一个成员变量：private int tickets = 100;
        2：在sellTicket类中重写run（）方法实现买票，代码步骤如下：
            A:判断票数大于0，就买票，并告知是哪个窗口卖的
            B:卖完了之后，总票数减1
            C:票没有了，可能还有人问，所以这里用死循环让卖票的动作一直执行
        3：定义一个测试类SellticketDemo，里面有main方法，代码步骤如下：
            A:创建Sellticket类对象
            B:创建三个Thread类的对象，把sellTicket对象作为构造方法的参数，并给出对应的窗口名称
            C:启动线程
 */
public class SellTicktesDemo {

    public static void main(String[] args) {

        //创建Sellticket类对象
        SellTicket st = new SellTicket();

        //创建三个Thread类的对象，把sellTicket对象作为构造方法的参数，并给出对应的窗口名称
        Thread t1 = new Thread(st,"窗口1");
        Thread t2 = new Thread(st,"窗口2");
        Thread t3 = new Thread(st,"窗口3");

        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }

}
