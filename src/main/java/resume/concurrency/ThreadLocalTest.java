package resume.concurrency;

public class ThreadLocalTest {
    public static void main(String[] args) {
         ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
         threadLocal.set(2);
    }
}
