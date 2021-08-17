package concurrency.resume;

//    原文链接：https://blog.csdn.net/u011943534/article/details/91400133

public class ThreadRank {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Work(null));
        Thread t2 = new Thread(new Work(t1));
        Thread t3 = new Thread(new Work(t2));
        t1.setName("第一个");
        t2.setName("第二个");
        t3.setName("第三个");
        t1.start();
        t2.start();
        t3.start();
    }

    static class Work implements Runnable {
        private Thread thread;

        public Work(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            if (thread != null) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                execute();
            } else {
                execute();
            }
        }

        private void execute() {
            System.out.println("线程" + Thread.currentThread().getName() + "执行");
        }
    }
}
