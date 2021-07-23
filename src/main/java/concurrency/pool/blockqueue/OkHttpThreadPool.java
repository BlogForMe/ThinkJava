package concurrency.pool.blockqueue;


import java.util.concurrent.*;

public class OkHttpThreadPool {

    public static void main(String[] args) {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(
//                0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

//     ThreadPoolExecutor executor = new ThreadPoolExecutor(
//                0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));




//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);      //LinkedBlockingQueue
//        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();     // LinkedBlockingQueue
//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();             // SynchronousQueue
//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(0); //DelayedWorkQueue
//        ScheduledExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(); //DelayedWorkQueue



        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        executor.execute(() -> {
            System.out.println("任务1");
            System.out.println(Thread.currentThread());
            while (true) {

            }
        });

        executor.execute(() -> {
            System.out.println("任务1");
            System.out.println(Thread.currentThread());
        });

        executor.execute(() -> {
            System.out.println("任务1");
            System.out.println(Thread.currentThread());
        });




    }
}
