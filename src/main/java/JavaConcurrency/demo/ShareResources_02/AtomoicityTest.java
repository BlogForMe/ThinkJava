package JavaConcurrency.demo.ShareResources_02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jon on 16-4-16.
 * 21.3
 * 原子性
 */
public class AtomoicityTest implements  Runnable {
    private  int i=0;
    public  int getvalue() {return  i;}
    private  synchronized  void evenIncrement(){i++ ;i++ ;}
    @Override
    public void run() {
     while (true)
         evenIncrement();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomoicityTest at = new AtomoicityTest();
        exec.execute(at);
        while (true){
            int val =at.getvalue();
            if (val%2!=0){
                System.out.println(val);
                System.exit(0);
            }
        }

    }


}
