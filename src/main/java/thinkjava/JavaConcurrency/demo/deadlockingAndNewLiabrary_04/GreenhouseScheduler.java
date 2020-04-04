package thinkjava.JavaConcurrency.demo.deadlockingAndNewLiabrary_04;

import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by jon on 17-1-1.
 * 21.7.5 使用ScheduledExecutor 的温室控制器
 */
public class GreenhouseScheduler {
    private volatile boolean light = false;
    private volatile boolean water = false;
    private String thermostat = "Day";

    public String getThermostat() {
        return thermostat;
    }

    public void setThermostat(String thermostat) {
        this.thermostat = thermostat;
    }

    ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);

    public void schedule(Runnable event, Long delay) {
        scheduler.schedule(event, delay, TimeUnit.SECONDS);
    }

    public void repeat(Runnable event, Long initialDelay, long period) {
        scheduler.scheduleAtFixedRate(event, initialDelay, period, TimeUnit.MICROSECONDS);
    }

    class LightOn implements Runnable {
        @Override
        public void run() {
            //Put hardware control code here to
            //physically turn on the light
            System.out.println("Turning on lights");
            light = true;
        }
    }

    class LightOff implements Runnable {
        @Override
        public void run() {
            //Put hardware control code here to physically turn off the light.
            System.out.println("Turning off lights");
            light = false;
        }
    }

    class WaterOn implements Runnable {
        @Override
        public void run() {
            //Put hardware control code here.
            System.out.println("Turning greenhouse water on");
        }
    }

    class WaterOff implements Runnable {
        @Override
        public void run() {
            //Put hardware control code here
            System.out.println("Truning greenhouse water off");
            water = false;
        }
    }

    class ThermostatNight implements Runnable {
        @Override
        public void run() {
            //Put hardware control code here.
            System.out.println("Thermostat to night setting ");
            setThermostat("Night");
        }
    }

    class ThermostatDay implements Runnable {
        @Override
        public void run() {
            //Put hardware control code here.
            System.out.println("Turning greenhouse water off");
            water = false;
        }
    }

    class Bell implements Runnable {
        @Override
        public void run() {
            System.out.println("Bing!");
        }
    }

    class Terminate implements Runnable {
        @Override
        public void run() {
            System.out.println("Terminating");
            scheduler.shutdownNow();
            //Must start a separate task to do this job,since the scheduler has been shut down;
            new Thread() {
                @Override
                public void run() {
                    for (DataPoint d : data)
                        System.out.println(d);
                }
            }.start();
        }
    }

    //New feature : data collection
    static class DataPoint {
        final Calendar time;
        final float temperature;
        final float humidity;

        public DataPoint(Calendar time, float temperature, float humidity) {
            this.time = time;
            this.temperature = temperature;
            this.humidity = humidity;
        }

        @Override
        public String toString() {
            return time.getTime() + String.format(" temperature: %1$.1f humidity: %2$.2f,temperature ,humidity ");
        }
    }

    private Calendar lastTime = Calendar.getInstance();

    {
        //Adjust date to the half hour
        lastTime.set(Calendar.MINUTE, 30);
        lastTime.set(Calendar.SECOND, 00);
    }

    private float lastTemp = 65.0f;
    private int tempDirection = +1;
    private float lastHumidity = 50.0f;
    private int humidityDirection = +1;
    private Random rand = new Random(47);
    List<DataPoint> data = Collections.synchronizedList(new ArrayList<>());

    class CollectData implements Runnable {
        @Override
        public void run() {
            System.out.println("Collectiong data");
            synchronized (GreenhouseScheduler.this) {
                //Pretend the interval is longer than it is:
                lastTime.set(Calendar.MINUTE, lastTime.get(Calendar.MINUTE
                ) + 30);
                //One in 5 changces of reversing the direction:
                if (rand.nextInt(5) == 4)
                    tempDirection = -tempDirection;
                //Store previous value:
                lastTemp = lastTemp + tempDirection * (1.0f + rand.nextFloat());
                //Calendar must be cloned,otherwise all
                //DataPoints hold references to the same lastTime.
                //For a basic object liek Calendar,clone() is Ok.
                data.add(new DataPoint((Calendar) lastTime.clone(), lastTemp, lastHumidity));
            }
        }
    }

    public static void main(String[] args) {
        GreenhouseScheduler gh = new GreenhouseScheduler();
        gh.schedule(gh.new Terminate(), 5000L);
        //Former "Restart" class not necessary
//        gh.repeat(gh.new Bell(), 0L, 1000);
        gh.repeat(gh.new ThermostatNight(), 0L, 2000);
//        gh.repeat(gh.new LightOn(), 0L, 200);
//        gh.repeat(gh.new LightOff(), 0L, 400);
//        gh.repeat(gh.new WaterOn(), 0L, 600);
//        gh.repeat(gh.new WaterOff(), 0L, 800);
//        gh.repeat(gh.new ThermostatDay(), 0L, 1400);
        gh.repeat(gh.new CollectData(), 500L, 500);
    }

}
