package JavaConcurrency.Exercise;

import net.mindview.util.Print;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by jon on 16-12-28.
 * 为什么这样不可以
 */
public class Exercise_22 {
    public static void main(String[] args) throws Exception {
        Task task = new Task();
        Runnable run1 = new Quick1Runnable(task),
                run2 = new Quick2Runnable(task);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.submit(run1);
        exec.submit(run2);
        TimeUnit.MILLISECONDS.sleep(5);
        exec.shutdown();
    }
}

class Task {
    boolean taskFlag = false;

    public synchronized void changeTrue() {
        taskFlag = true;
    }

    public synchronized void changeFalse() {
        taskFlag = false;
    }
}

class Quick1Runnable implements Runnable {
    private Task task;

    public Quick1Runnable(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        Print.print("Quick1Runnable run()");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        task.changeTrue();
        Print.print("Quick1Runnable task.changeTrue() ");

    }
}

class Quick2Runnable implements Runnable {
    private Task task;

    public Quick2Runnable(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        while (task.taskFlag == true) {
            Print.print("Quick2Runnable run()");
            task.changeFalse();
            Print.print("Quick2Runnable.run change false");
        }

    }
}

