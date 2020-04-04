package thinkjava.JavaIo.Demo.BasicIO_01;


import thinkjava.JavaIo.Utils.Constants;
import java.io.*;

/**
 * Created by jon on 16-4-2.
 * 18.3.3 标准IO重定向
 */
public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(thinkjava.JavaIo.Utils.Constants.hpBasicIoU + "Redirecting.java"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(Constants.writePathU + "thinkjava.test.out")));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null)
            System.out.println(s);

        System.setOut(console);
        in.close();
        out.close();


    }
}
