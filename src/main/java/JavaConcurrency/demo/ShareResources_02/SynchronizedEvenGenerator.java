package JavaConcurrency.demo.ShareResources_02;

/**
 * Created by jon on 16-4-15.
 * 同步
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {   //使用了同步后就不会出现抢夺资源情况了
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;

        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
