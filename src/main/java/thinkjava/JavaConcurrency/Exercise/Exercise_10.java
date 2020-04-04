package thinkjava.JavaConcurrency.Exercise;


import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by jon on 16-12-26.
 */
public class Exercise_10 {
    public static void main(String[] args) {
        ArrayList<Future<Integer>> results = new ArrayList<>();
        Fibonacci2.init();
        for (int i = 1; i < 5; i++)
            results.add(Fibonacci2.runTask(i));
        Thread.yield();
        for (Future<Integer> fi : results)
            try {
                System.out.println(fi.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
    }

}

class Fibonacci2 {
    private static ExecutorService exec;

    public static Future<Integer> runTask(int n) {

        return exec.submit(new Callable() {

            @Override
            public Object call() throws Exception {
                int sum = 0;
                for (int i = 0; i <= n; i++)
                    sum += fib(i);

                return sum;
            }
        });
    }

    private static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }

    public static synchronized void init() {
        if (exec == null) {
            exec = Executors.newCachedThreadPool();
        }
    }

    public static synchronized void shutdown() {
        if (exec != null)
            exec.shutdown();
        exec = null;
    }

}

