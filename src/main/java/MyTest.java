import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyTest {
    public static void main(String[] args) {
        ProcessClick process = new ProcessClick(new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("已经点击");
            }
        });
        process.click();


        ExecutorService service = Executors.newFixedThreadPool(10);
        service.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                return null;
            }
        });
    }
}


interface OnClickListener{
    void  onClick();
}

class  ProcessClick {
    OnClickListener listener;

    public ProcessClick(OnClickListener listener) {
        this.listener = listener;
    }

    void click(){
        listener.onClick();
    }
}
