package JavaConcurrency.demo.BasicThreadSyntax_01;

/**
 * * Created by jon on 16-4-13.
 *    21.2.1 定义任务
 */
public class LiftOff implements  Runnable {


    protected int countDown = 10;  //defaultf
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }


    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff！") + "),";
    }

//    @Override
//    public String toString() {
//        return "LiftOff    " + id;
//    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }
}
class MoreBasicThreads{
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            new Thread(new LiftOff()).start();
            System.out.println("Waiting for liftOff");
        }
    }
}
