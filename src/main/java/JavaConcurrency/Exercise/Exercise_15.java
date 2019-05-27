package JavaConcurrency.Exercise;

import net.mindview.util.Print;


/**
 * Created by Administrator on 2016/12/27.
 */
public class Exercise_15 {
    public static void main(String[] args) {
        SyncExercise ds = new SyncExercise();
        SyncExercise ds1 = new SyncExercise();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ds.a(1);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ds1.a(2);
            }
        }).start();
//        ds.c();

    }
}


class SyncExercise {
    Object object = new Object();
//    Object object1 = new Object();  //不同的对象同步

    public synchronized void a(int n) {
        synchronized (object) {
        for (int i = 0; i < 5; i++) {
            Print.print("a()" + n);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                }
            }
        }
    }

    public void b() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                Print.print("b()");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    public void c() {
//        synchronized (object1) {
//            for (int i = 0; i < 5; i++) {
//                Print.print("c()");
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}
