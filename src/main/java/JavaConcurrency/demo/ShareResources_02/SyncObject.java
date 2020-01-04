package JavaConcurrency.demo.ShareResources_02;


/**
 * Created by Jon on 2016/5/2.
 * 21.3.6在其他对象上同步
 * <p>
 * Synchronizing on another object
 */
class DualSynch {
    private Object syncObject = new Object();

    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.print("  f()  ");
            Thread.yield();
        }
    }

    public  void g() {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.print("  g()  ");
                Thread.yield();
            }
        }
    }
}

public class SyncObject {
    public static void main(String[] args) {
        DualSynch ds = new DualSynch();
        new Thread() {
            @Override
            public void run() {
                super.run();
                ds.f();
            }
        }.start();
        ds.g();
    }
}
