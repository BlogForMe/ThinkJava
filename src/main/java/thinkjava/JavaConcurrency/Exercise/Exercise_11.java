package thinkjava.JavaConcurrency.Exercise;

import thinkjava.net.mindview.util.Generator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 这个和答案不一样
 *
 * Created by Administrator on 2016/12/27.
 * 实现了 Generator方法操作
 */
public class Exercise_11 {
    public static void main(String[] args) {
        ShareVenten.test(new OperationGenerator());
    }
}

class ShareVenten implements Runnable {
    private OperationGenerator opGenerator;

    public ShareVenten(Generator opGenerator, int i) {
        this.opGenerator = (OperationGenerator) opGenerator;
    }

    @Override
    public void run() {
        while (!opGenerator.isCanceled()) {
            int val = opGenerator.next();
            System.out.println(val);
            if (val % 2 != 0) {
                System.out.println(val + " is not oven");
                opGenerator.canceled();
            }
        }

    }


    public static void test(OperationGenerator operationGenerator) {
        test(operationGenerator, 10);
    }

    private static void test(Generator opGenerator, int n) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < n; i++) {
            exec.submit(new ShareVenten(opGenerator, i));
        }
        exec.shutdown();

    }
}


class OperationGenerator implements Generator<Integer> {
    private volatile boolean canceled = false;
    private int currentCount = 0;

    @Override
    public synchronized Integer next() {
        ++currentCount;
        Thread.yield();
        ++currentCount;
        return currentCount;
    }

    public void canceled() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }

}


