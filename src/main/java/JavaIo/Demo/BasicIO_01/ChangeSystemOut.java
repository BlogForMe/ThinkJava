package JavaIo.Demo.BasicIO_01;

import java.io.PrintWriter;

/**
 * Created by jon on 16-4-2.
 *  将system.out转换成PrintWriter
 * 18.2.2
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello world");
    }
}
