package Exception.Exercise;

/**
 * Created by jon on 17-5-25.
 */

class ResumerException extends Exception {
}

class Resumer {
    static int count = 5;

    static void f() throws ResumerException {
        if (--count > 0)
            throw new ResumerException();
    }
}

public class E05_Resumption {
    public static void main(String[] args) {
        while (true) {
            try {
                Resumer.f();
            } catch (ResumerException e) {
                System.out.println("Caught " + e);
                continue;
            }
            System.out.println("Got throug...");
            break;
        }
        System.out.println("Successful execution");
    }
}
