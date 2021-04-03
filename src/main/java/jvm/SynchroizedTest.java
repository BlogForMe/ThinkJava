package jvm;

public class SynchroizedTest {


    public static void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SynchroizedTest.setValue(1);

            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(SynchroizedTest.getValue());
            }
        }).start();

    }


    private volatile static int value = 0;

    public synchronized static void setValue(int vs) {
        value = vs;
    }

    public synchronized static int getValue() {
        return value;
    }
}
