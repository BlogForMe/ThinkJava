package JavaIo.Demo.BasicIO_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jon on 16-4-2.
 * 标准IO
 * 18.8.1
 */
public class Echo {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = stdin.readLine()) != null) {
            System.out.println(s);

        }
    }
}
