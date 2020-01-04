package Exception.Exercise;

/**
 * Created by jon on 17-5-24.
 */

class E01Exception extends Exception {
    public E01Exception(String msg) {
        super(msg);
    }
}

public class E01_E {
    public static void e() throws E01Exception {
        System.out.println("throw E01Exception");
        throw new E01Exception("输出　E01Exception异常");
    }

    public static void main(String[] args) {
        try {
            e();
        } catch (E01Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("finally　得到执行");
        }

    }
}
