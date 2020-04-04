package thinkjava.JavaConcurrency.Exercise;

import thinkjava.net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2016/12/26.
 */
public class Exercise_05 {

    public static void main(String[] args) {
        ArrayList<Future<Integer>> results = new ArrayList<>();

        ExecutorService exec = Executors.newCachedThreadPool();
         for (int i=0;i<4;i++){
             results.add(exec.submit(new Exercise_05().new Fibonacci(i)));
         }

        int sum = 0;
        for (Future<Integer> fs : results) {
            try {
                sum += fs.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }

        }

    }


    class Fibonacci implements Generator<Integer>, Callable {
        private int count;
        private int n;

        public Fibonacci(int n) {
            this.n = n;
        }

        @Override
        public Object call() throws Exception {
            int sum = 0;
            for (int i = 0; i < n; i++)
                sum += next();
            return sum;
        }

        @Override
        public Integer next() {
            return fib(count++);
        }

        private int fib(int n) {
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            }
            return fib(n - 2) + fib(n - 1);
        }
    }


}
