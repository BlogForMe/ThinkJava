package JavaConcurrency.demo.StopTaskAndCooperate_03;

import net.mindview.util.Print;

import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/28.
 * 21.4.3 中断
 * <p>
 * SYSTEM这个输入流没有释放资源
 */
public class CloseResource {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
//        ServerSocket server = new ServerSocket(8080);
        InputStream socketInput = new Socket("localhost", 8080).getInputStream();
        exec.execute(new IOBlocked(socketInput));
        exec.execute(new IOBlocked(System.in));
        TimeUnit.MILLISECONDS.sleep(100);
        Print.print("Shutting down all threads");
        exec.shutdownNow();
        TimeUnit.SECONDS.sleep(1);
        Print.print("Clasing " + socketInput.getClass().getName());
        socketInput.close(); //Releases blocked Thread

        TimeUnit.SECONDS.sleep(1);
        Print.print("Closing " + System.in.getClass().getName());
        System.in.close();   //Releases blocked thread
    }
}
