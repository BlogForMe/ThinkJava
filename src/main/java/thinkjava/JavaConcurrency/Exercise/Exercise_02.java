package thinkjava.JavaConcurrency.Exercise;


import thinkjava.net.mindview.util.Generator;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/12/26.
 */
public class Exercise_02 {


    public static void main(String[] args) {
        ExecutorService exce = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exce.submit(new Exercise_02().new Fibonacci(i));
        exce.shutdown();
    }


    /**
     * Created by Administrator on 2016/12/26.
     * 费波那契数列
     */
    class Fibonacci implements Generator<Integer>, Runnable {
        private int count;
        int n;

        public Fibonacci(int n) {
            this.n = n;
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

        @Override
        public void run() {
            Integer[] integer = new Integer[n];
            for (int i = 0; i < n; i++) {
                integer[i] = next();
            }
            System.out.println(Arrays.toString(integer));
        }
    }
}
