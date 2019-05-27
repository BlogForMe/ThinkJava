package JavaIo.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jon on 17-1-7.
 */
public class E_21_SystemIn {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = in.readLine()) != null) {
            System.out.println(s.toUpperCase());
        }
    }
}
