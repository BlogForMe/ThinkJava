package JavaConcurrency.demo.ShareResources_02;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Jon on 2016/5/1.
 * AtomicInteger 重写 MutexEvenGenerator
 * <p>
 * Atomic classes are occasionally useful in regular code
 */
public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger currentEvenValue = new AtomicInteger(0);

    @Override
    public int next() {
        return currentEvenValue.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
