package thinkjava.JavaConcurrency.demo.deadlockingAndNewLiabrary_04;

import thinkjava.Generics.Demo.InterfaceAndMethod_02.BasicGenerator;
import thinkjava.net.mindview.util.Generator;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by jon on 17-1-1.
 * 21.7.7 Exchanger
 */

class ExchangerProducer<T> implements Runnable {
    private Generator<T> generator;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;

    public ExchangerProducer(Exchanger<List<T>> exchg, Generator<T> gen, List<T> holder) {
        this.holder = holder;
        exchanger = exchg;
        generator = gen;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < ExchangerDemo.size; i++)
                    holder.add(generator.next());
                //Exchange full for empty;
                holder = exchanger.exchange(holder);
            }
        } catch (InterruptedException e) {
            //Ok to terminate this way.
        }
    }
}

class ExchangerConsumer<T> implements Runnable {
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value;

    public ExchangerConsumer(Exchanger<List<T>> exchanger, List<T> holder) {
        this.exchanger = exchanger;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted())
                holder = exchanger.exchange(holder);
            for (T x : holder) {
                value = x; //Fetch out value
                holder.remove(x); //Ok for CopyOnWriteArrayList
            }
        } catch (InterruptedException e) {
            //OK to terminate this way
        }
        System.out.println("Final value: " + value);
    }
}

public class ExchangerDemo {
    static int size = 10;
    static int delay = 5;  //Seconds

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();

        Exchanger<List<Fat>> xc = new Exchanger<>();
        List<Fat>
                producerList = new CopyOnWriteArrayList<>(),
                consumerList = new CopyOnWriteArrayList<>();
        exec.execute(new ExchangerProducer<>(xc, BasicGenerator.create(Fat.class), producerList));
//        exec.execute(new ExchangerConsumer<>(xc, consumerList));
        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();
    }
}
