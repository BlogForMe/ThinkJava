package JavaConcurrency.demo.BasicThreadSyntax_01;

/**
 * Created by jon on 16-4-15.
 * 21.2.9
 */
public class SelfManaged implements Runnable {
    private  int coutDown = 5;
    private  Thread t = new Thread(this);

    public SelfManaged() {
        t.start();
    }

    @Override
    public String toString() {
        return Thread.currentThread().getName() +"(" + coutDown +"),";
    }

    @Override
    public void run() {
        while (true){
            System.out.println(this);
            if(--coutDown==0)
                return;
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<5;i++)
            new SelfManaged();
    }
}
