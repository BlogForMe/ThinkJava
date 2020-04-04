package thinkjava.JavaConcurrency.Exercise;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/12/27.
 */
public class Exercise_14 {
    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++)
            new Timer().schedule(new MyTimer(), 5000);

    }
}

class MyTimer extends TimerTask {

    @Override
    public void run() {
        int i = 0;
        i++;
        System.out.println(i);
    }
}
