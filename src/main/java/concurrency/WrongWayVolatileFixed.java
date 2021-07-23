package concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * https://juejin.cn/post/6844903933249323016
 */
public class WrongWayVolatileFixed {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue storage = new ArrayBlockingQueue(10);
        WrongWayVolatileFixed body = new WrongWayVolatileFixed();
        Producer producer = body.new Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(1000);

        Consumer consumer = body.new Consumer(storage);
        while (consumer.needMoreNums()) {
            System.out.println(storage.take()+"被消费");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多数据了");
        /**
         *  一旦消费不需要更多数据了，我们应该让生产者也停下来，
         *  但是实际情况,在 storage.put(num);处被阻塞了，无法进入新的一层while()循环中判断，!Canceled 的值也就无法判断
         */
        producerThread.interrupt();

    }
    class Producer implements Runnable{

        BlockingQueue storage;

        public Producer(BlockingQueue storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            int num = 0;
            try {
                //canceled为true，则无法进入
                while (num <= 100000 && !Thread.currentThread().isInterrupted()) {
                    if (num % 100 == 0) {
                        storage.put(num);
                        System.out.println(num + "是100的倍数,被放到仓库中了。");
                    }
                    num++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("生产者结束运行");
            }
        }

    }

    class Consumer {

        BlockingQueue storage;

        public Consumer(BlockingQueue storage) {
            this.storage = storage;
        }

        public boolean needMoreNums() {
            if (Math.random() > 0.95) {
                return false;
            }
            return true;
        }
    }

}
