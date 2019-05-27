package JavaConcurrency.Exercise;


import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/12/26.
 * 并发练习题第一题
 */
public class Exercise_01 {

    private static int taskCount = 4;
    private static int taskId = 0;

    class Exercise_01Runnable implements Runnable {
        int id = taskId++;

        @Override
        public void run() {
            System.out.println("I am  1  ID =  " + id);
            Thread.yield();

            System.out.println("I am  2   ID = " + id);
            Thread.yield();

            System.out.println("I am  3  ID =  " + id);
            Thread.yield();

            System.out.println("I am  END  ID =" + id);

        }
    }


    public static void main(String[] args) {
        for (int i = 1; i < taskCount; i++) {
            Executors.newCachedThreadPool().submit(new Exercise_01().new Exercise_01Runnable());
        }

    }

}
