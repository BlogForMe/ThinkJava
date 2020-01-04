package JavaConcurrency.demo.ShareResources_02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jon on 16-4-15.
 * 21.3 共享受限资源
 * <p>
 * <p>
 * 理解 ： 同时启动10个任务，抢夺EvenGenerator的next()
 * 由于JAVA中递增不是原子性的，所以很有可能出现第一个递增没完成就被抢夺，后面执行出现不少偶数的情况
 */

class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator generator, int ident) {
        this.id = ident;
        this.generator = generator;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            System.out.println(val);
            if (val % 2 != 0) {
                System.out.println(val + "not even!");
                generator.cancel();
            }
        }

    }

    //text any type of  IntGenerator
    public static void test(IntGenerator gp, int count) {
        System.out.println("Press Controc-c to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++)
            exec.execute(new EvenChecker(gp, i));
        exec.shutdown();
    }

    //Default value for count
    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}

public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    public int next() {
        ++currentEvenValue;
        Thread.yield();  //用这个可以更快的发现问题
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
