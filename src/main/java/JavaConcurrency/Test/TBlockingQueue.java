package JavaConcurrency.Test;

import JavaConcurrency.demo.BasicThreadSyntax_01.LiftOff;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Administrator on 2017/1/11.
 */
public class TBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<LiftOff> aQueue = new LinkedBlockingDeque<>();
        for (int i = 0; i < 4; i++)
            try {
                aQueue.put(new LiftOff(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        Executors.newCachedThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!aQueue.isEmpty()) {
                        LiftOff rocket = aQueue.take();
                        rocket.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
