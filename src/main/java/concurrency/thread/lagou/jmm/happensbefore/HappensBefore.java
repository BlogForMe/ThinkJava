package concurrency.thread.lagou.jmm.happensbefore;

public class HappensBefore {
    public static void main(String[] args) {
        HappensBefore happensBefore = new HappensBefore();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                happensBefore.setValue(1);
            } catch (InterruptedException e) {

            }
        }).start();

        new Thread(() -> {
            System.out.println(happensBefore.value);
        }).start();

    }

    private  volatile  int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
