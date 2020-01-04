package JavaConcurrency.demo.BasicThreadSyntax_01;

/**
 * Created by jon on 16-4-15.
 * 21.2.12 创建有响应的用户界面
 *
 * 我的理解 ： Main所在的任务结束，后台线程也跟着结束了
 */
class UnresponsiveUI {
    private volatile double d = 1;

    public UnresponsiveUI() throws Exception {
        while (d > 0)
            d = d + (Math.PI + Math.E) / d;
        System.in.read();
    }
}

public class ResponsiveUI extends Thread {
    private static volatile double d = 1;

    public ResponsiveUI() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws Exception {
        new UnresponsiveUI();    //Must kill this process
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);


    }
}
