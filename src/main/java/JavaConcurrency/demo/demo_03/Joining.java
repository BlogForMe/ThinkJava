package JavaConcurrency.demo.demo_03;

import net.mindview.util.Print;


/**
 * Created by jon on 16-4-15.
 * 21.2.11 加入一个线程
 *
 *
 * 我的理解 ：  在Joiner线程里面调用Sleeper线程 的join() , Joiner任务必须等Sleeper任务结束活被打断或结束　才恢复
 */


class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        super.run();
        try {
            sleep(duration);
//            Print.print(getName()+"执行了");
        } catch (InterruptedException e) {
            Print.print(getName() + "  被打断" + "isInterrupted()  " + isInterrupted());
            return;
        }
        Print.print(getName() + "   has awakened");
    }
}

public class Joining {
    public static void main(String[] args) {
        Sleeper
                sleepy = new Sleeper("Sleepy", 1500),
                grumpy = new Sleeper("Grumpy", 1500);

//        Joiner
//                dopey = new Joiner("Dopey", sleepy),
//                doc = new Joiner("Doc", grumpy);
//        grumpy.interrupt();  //调用了这个方法后   grumpy.join()就被中断了 打出 第一条日志  Grumpy  被打断isInterrupted()  false
        //接着打印  Doc   join completed


    }

}