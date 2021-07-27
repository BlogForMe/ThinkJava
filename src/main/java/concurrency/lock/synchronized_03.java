package concurrency.lock;

import java.util.concurrent.TimeUnit;

public class synchronized_03 implements Runnable {
    static synchronized_03 instance=new synchronized_03();
    static int i=0;
    @Override
    public void run() {
        //省略其他耗时操作....
        //使用同步代码块对变量i进行同步操作,锁对象为instance
        synchronized(instance){
            for(int j=0;j<1000000;j++){
                i++;
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        //new新实例
        Thread t1 = new Thread(new synchronized_03());
        t1.start();
        System.out.println(i);
    }
}
//————————————————
//        版权声明：本文为CSDN博主「zejian_」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https://blog.csdn.net/javazejian/article/details/72828483