package JavaConcurrency.demo.BasicThreadSyntax_01;

import java.util.concurrent.*;

/**
 * Created by jon on 16-4-14.
 * 21.2.4 从任务中产生返回值
 */
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "任务的结果是" + id;
    }
}

class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
//        ArrayList<Future<String>> results = new ArrayList<>();
//        for (int i = 0; i < 10; i++)
//            results.add(exec.submit(new TaskWithResult(i)));
//
//        for (Future<String> fs : results) {
//            try {
//                System.out.println(fs.get());
//            } catch (InterruptedException e) {
//                System.out.println(e);
//            } catch (ExecutionException e) {
//                System.out.println(e);
//            } finally {
//                exec.shutdown();
//            }
//        }

        TaskWithResult tTask = new TaskWithResult(1);

        Future<String> futureTask = exec.submit(tTask);
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}