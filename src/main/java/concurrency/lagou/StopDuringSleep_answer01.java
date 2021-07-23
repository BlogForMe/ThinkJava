package concurrency.lagou;

public class StopDuringSleep_answer01 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                subTas1();
//                try {
//                    subTas2();
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
            }
            System.out.println("thread  isInterrupted " + Thread.currentThread().isInterrupted());
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(50);

        thread.interrupt();
    }

    private static void subTas2() throws InterruptedException {
        System.out.println("subTas2  isInterrupted " + Thread.currentThread().isInterrupted());
        Thread.sleep(1000);
    }

    private static void subTas1() /*throws InterruptedException */ {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // 在这里不处理该异常是非常不好的
            Thread.currentThread().interrupt();
        }
    }

}
