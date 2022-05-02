import pattern.uml.Person;

import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyTest {
    public static void main(String[] args) {
//        ProcessClick process = new ProcessClick(new OnClickListener() {
//            @Override
//            public void onClick() {
//                System.out.println("已经点击");
//            }
//        });
//        process.click();
//
//
//        ExecutorService service = Executors.newFixedThreadPool(10);
//        service.submit(new Callable<Integer>() {
//
//            @Override
//            public Integer call() throws Exception {
//                return null;
//            }
//        });
//        ArrayList<Person> objects = new ArrayList<>();
//        objects.add(null);
//        objects.add(null);
//        objects.add(null);
//        objects.add(null);
//        System.out.println(objects);
//        objects.forEach(it->{
//            System.out.println("输出 "+it);
//        });
//        boolean flag1 = (objects != null);
//        boolean flag2 = (objects.get(0) != null);
//        System.out.println("flag1 " + flag1);
//        System.out.println("flag2 " + flag2);
//        System.out.println((flag1&& flag2));

        ArrayList<Integer> bannerData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bannerData.add(i);
        }
        bannerData.subList(3,bannerData.size()).clear();
        System.out.println(bannerData.size());
    }

}


interface OnClickListener {
    void onClick();
}

class ProcessClick {
    OnClickListener listener;

    public ProcessClick(OnClickListener listener) {
        this.listener = listener;
    }

    void click() {
        listener.onClick();
    }
}
