package JavaConcurrency.demo.BasicThreadSyntax_01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jon on 16-4-14.
 * 21.2.3 使用Executor
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++)
            exec.execute(new LiftOff());
        exec.shutdown();

    }
}
