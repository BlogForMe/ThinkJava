package thinkjava.JavaConcurrency.demo.ShareResources_02;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Jon on 2016/5/1.
 * 21.2.5临界区
 * 对整个方法同步  和 对方法内部的部分代码同步的比较
 * <p>
 * <p>
 * 理解：   这个例子是  把PairManager1和PairManager2两个参数传给 两个不同的任务，PairManipulator任务是比较两种不同的同步方式，PairManipulator是给原子变量累加和验证x,y
 * PairManager1 、PairManager2给出两种不同的同步方式
 */

class Pair {  //Not thread-safe
    private int x, y;

    public Pair() {
        this(0, 0);
    }

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public class PairValueNotEqualException extends RuntimeException {
        public PairValueNotEqualException() {
            super("Pair values not equal:" + Pair.this);
        }
    }

    //Arbitrary invariant -- both variables muset be equal:
    public void checkState() {
        if (x != y)
            throw new PairValueNotEqualException();
    }
}

//Protect a Pair inside a thread-safe class:
abstract class PairManager {
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());

    public synchronized Pair getPair() {
        return new Pair(p.getX(), p.getY());
    }

    //Assume this is  a time consuming operating
    protected void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MICROSECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void increment();
}

//Synchronize the entire method
class PairManager1 extends PairManager {

    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}

//Use a critical secion :
class PairManger2 extends PairManager {
    @Override
    public synchronized void increment() {
        Pair temp;
//        synchronized (this) {
        p.incrementX();
        p.incrementY();
        temp = getPair();
//        }
        store(temp);
    }
}

class PairManipulator implements Runnable {
    private PairManager pm;

    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.increment();
        }
    }

    public String toString() {
        return "Pair:" + pm.getPair() + "chenCounter=" + pm.checkCounter.get();
    }
}

class PairChecker implements Runnable {
    private PairManager pm;

    public PairChecker(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}

public class CriticalSection {
    //Test the two different approaches:
    static void testApproaches(PairManager pman1, PairManager pman2) {
        ExecutorService exec = Executors.newCachedThreadPool();
        PairManipulator
                pm1 = new PairManipulator(pman1),
                pm2 = new PairManipulator(pman2);

        PairChecker
                pcheck1 = new PairChecker(pman1),
                pcheck2 = new PairChecker(pman2);
        exec.execute(pm1);
        exec.execute(pm2);
        exec.execute(pcheck1);
        exec.execute(pcheck2);

        try {
            TimeUnit.MICROSECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("pm1: " + pm1 + "\npm2:" + pm2);
        System.exit(0);

    }

    public static void main(String[] args) {
        PairManager pman1 = new PairManager1();
        PairManager pman2 = new PairManger2();
        testApproaches(pman1, pman2);
    }

}
