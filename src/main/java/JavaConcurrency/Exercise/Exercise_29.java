package JavaConcurrency.Exercise;


import net.mindview.util.Print;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/30.
 * //看完枚举完善吧！！！！！！
 */


class Toast {
    public enum Stauts {
        DRY, BUTTERED, JAMMED,
        READY {
            @Override
            public String toString() {
                return BUTTERED.toString() + " & " + JAMMED.toString();
            }
        }
    }

    private Stauts stauts = Stauts.DRY;
    private final int id;

    public Toast(int id) {
        this.id = id;
    }


    public void butter() {
        stauts = (stauts == Stauts.DRY) ? Stauts.BUTTERED : Stauts.READY;
    }

    public void jam() {
        stauts = (stauts == Stauts.DRY) ? Stauts.BUTTERED : Stauts.READY;
    }

    public Stauts getStauts() {
        return stauts;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast " + id + ":  " + stauts;
    }
}

class ToastQueue extends LinkedBlockingDeque<Toast> {
}

class Toaster implements Runnable {
    private ToastQueue toastQueue;
    private int count = 0;
    private Random random = new Random(47);

    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(500));
                //Make toast
                Toast t = new Toast(count++);
                //Insert into queue
                toastQueue.put(t);
            }
        } catch (InterruptedException e) {

        }
    }
}

//Apply butter implements toast;
class Butterer implements Runnable {
    private ToastQueue toastQueue, butteredQueue;

    public Butterer(ToastQueue toastQueue, ToastQueue butteredQueue) {
        this.toastQueue = toastQueue;
        this.butteredQueue = butteredQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //Blocks until next piece of toast is available;
                Toast t = toastQueue.take();
                t.butter();
                Print.print(t);
                butteredQueue.put(t);
            }
        } catch (InterruptedException e) {

        }
    }
}

class Jammer implements Runnable {
    private ToastQueue inQueue, jammedQueue;

    public Jammer(ToastQueue inQueue, ToastQueue jammedQueue) {
        this.inQueue = inQueue;
        this.jammedQueue = jammedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //Blocks until next piece of toast is available;
                Toast t = inQueue.take();
                t.jam();
                Print.print(t);
                jammedQueue.put(t);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Print.print("Jammer off");
    }
}

//Consume the toast:
class Eater implements Runnable {
    private ToastQueue finishedQueue;

    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            //Blocks until next piece of toast is available ;
            Toast t = finishedQueue.take();
            //Verify that all pieces are ready for consumption;
            if (t.getStauts() != Toast.Stauts.READY) {
//                TypeUtilities.getPrimitiveTypeByName(">>>> Error: " + t);
                System.exit(1);
            } else
                Print.print("Chomp!  " + t);
        } catch (InterruptedException e) {
            Print.print("Eater interrupted");
        }
        Print.print("Eater off");
    }
}

class Alternator implements Runnable {
    private ToastQueue inQueue, out1Queue, out2Queue;
    private boolean outTo2;//control alternation

    public Alternator(ToastQueue inQueue, ToastQueue out1Queue, ToastQueue out2Queue) {
        this.inQueue = inQueue;
        this.out1Queue = out1Queue;
        this.out2Queue = out2Queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //Blocks until next piece of toast is available;
                Toast t = inQueue.take();
                if (!outTo2)
                    out1Queue.put(t);
                else
                    out2Queue.put(t);
                outTo2 = !outTo2;//change state for next time
            }
        } catch (InterruptedException e) {
            Print.print("Alternator interrupted");
        }
        Print.print("Alternator off");
    }
}

class Merger implements Runnable {
    private ToastQueue in1Queue, in2Queue, toBeButteredQueue, toBeJammedQueue, finishedQueue;

    public Merger(ToastQueue in1Queue, ToastQueue in2Queue, ToastQueue toBeButteredQueue, ToastQueue toBeJammedQueue, ToastQueue finishedQueue) {
        this.in1Queue = in1Queue;
        this.in2Queue = in2Queue;
        this.toBeButteredQueue = toBeButteredQueue;
        this.toBeJammedQueue = toBeJammedQueue;
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //Blocks until next piece of toast is available
                Toast t = null;
                while (t == null) {
                    t = in1Queue.poll(50, TimeUnit.MILLISECONDS);
                    if (t != null)
                        break;
                    t = in2Queue.poll(50, TimeUnit.MILLISECONDS);
                }
                //Relay toast onto the proper queue
                switch (t.getStauts()) {
                    case BUTTERED:
                        toBeButteredQueue.put(t);
                        break;
                    case JAMMED:
                        toBeButteredQueue.put(t);
                        break;
                    default:
                        finishedQueue.put(t);
                }
            }
        } catch (InterruptedException e) {
            Print.print("Merger interrupted");
        }
        Print.print("Merger off");
    }
}

public class Exercise_29 {
    public static void main(String[] args) throws Exception {
        ToastQueue dryQueue = new ToastQueue(),
                butteredQueue = new ToastQueue(),
                teBeButteredQueue = new ToastQueue(),
                jammedQueue = new ToastQueue(),
                toBeJammedQueue = new ToastQueue(),
                finishedQueue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Alternator(dryQueue, teBeButteredQueue, toBeJammedQueue));
        exec.execute(new Butterer(teBeButteredQueue, butteredQueue));
        exec.execute(new Merger(butteredQueue, jammedQueue, teBeButteredQueue, toBeJammedQueue, finishedQueue));
        exec.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
