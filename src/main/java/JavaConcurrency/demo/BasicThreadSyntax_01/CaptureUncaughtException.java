package JavaConcurrency.demo.BasicThreadSyntax_01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by jon on 16-4-15.
 * 21.2.14异常捕获
 * <p>
 * 不懂！！！！！！！
 * <p>
 * <p>
 * 新创建的Thread对象附着 Thread.UncaughtExceptionHandler (异常处理器)
 * 把这个工厂传递给Executors创建的ExecutorService的方法
 *
 * 疑惑：对于 ExceptionThread2任务的异常为什么可以扑获 !!!! ?
 */

class ExceptionThread2 implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("eh =" + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}


class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught" + e);
    }
}

class HandlerThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("crated" + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}

public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}
