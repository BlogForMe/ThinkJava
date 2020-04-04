package thinkjava.JavaConcurrency.demo.BasicThreadSyntax_01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jon on 16-4-15.
 * 21.2.14 捕获异常
 * <p>
 * 下面注释的处理器，这个处理器只有不存在线程专有的未扑获异常处理器的情况下才会被调用
 */
public class ExceptionThread implements Runnable {

    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
//        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());

        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        } catch (RuntimeException ue) {
            //This statement will Not execute!
            System.out.println("thinkjava.Exception has been handled!");
        }

    }
}
