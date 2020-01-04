package JavaConcurrency.demo.deadlockingAndNewLiabrary_04;

import net.mindview.util.Print;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Jon on 2016/6/6.
 * 21.7.3匿名内部类部分看不懂
 * <p>
 * <p>
 * 所有的线程执行到 barrier.await();等待，最后一个到这里后，就接着往后执行
 */

class Horse implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private int strides = 0;
    private static Random rand = new Random(47);
    private static CyclicBarrier barrier;

    public Horse(CyclicBarrier b) {
        this.barrier = b;
    }

    public synchronized int getStrides() {
        return strides;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    strides += rand.nextInt(3);  // Porduces 0,1,2
                }

                //这里是线程集结地
                barrier.await();
            }
        } catch (InterruptedException e) {
            //A legitimate way to exit
        } catch (BrokenBarrierException e) {
            //This one we want to know about
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Horse " + id + " ";
    }

    public String tracks() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < getStrides(); i++)
            s.append("*");
        s.append(id);
        return s.toString();
    }
}

public class HorseRace {
    static final int FINISH_LINE = 75;
    private List<Horse> horses = new ArrayList<Horse>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;

    public HorseRace(int nHorses, final int pause) {
        barrier = new CyclicBarrier(nHorses, new Runnable() {
            @Override
            public void run() {
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < FINISH_LINE; i++)
                    s.append("=");  //The fence on  the racetrack
                Print.print(s);
                for (Horse horse : horses)
                    Print.print(horse.tracks());
                for (Horse horse : horses)
                    if (horse.getStrides() >= FINISH_LINE) {
                        Print.print(horse + " Won!");
                        exec.shutdownNow();
                        return;
                    }
                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch (InterruptedException e) {
                    Print.print("barrier-action sleep interrupted");
                }
            }
        });
        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }

    public static void main(String[] args) {
        int nHorses = 7;
        int pause = 200;
//        if (args.length > 0) {
//            int n = new Integer(args[0]);
//            nHorses = n > 0 ? n : nHorses;
//        }
//        if (args.length > 1) {
//            int p = new Integer(args[1]);
//            pause = p > -1 ? p : pause;
//        }
        new HorseRace(nHorses, pause);
    }
}