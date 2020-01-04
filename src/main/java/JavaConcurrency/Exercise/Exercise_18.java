package JavaConcurrency.Exercise;

import net.mindview.util.Print;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/28.
 */
public class Exercise_18 {
    public static void main(String[] args) {
        Thread t = new Thread(new RunTask());
        t.start();

        t.interrupt();
    }
}

class NonTask {
    static void longMethod() throws InterruptedException {
        TimeUnit.SECONDS.sleep(60);  //Waits one minute
    }
}

class RunTask implements Runnable {

    @Override
    public void run() {
        Print.print("ready to  run()");
        try {
            NonTask.longMethod();
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
        Print.print("exiting RunTask.run()");
    }
}
