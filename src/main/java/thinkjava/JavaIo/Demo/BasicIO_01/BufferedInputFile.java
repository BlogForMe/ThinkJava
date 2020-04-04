package thinkjava.JavaIo.Demo.BasicIO_01;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by jon on 16-4-2.
 * 18.6.1缓冲输入文件
 */
public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null)
            sb.append(s + "\n");
        in.close();
        return sb.toString();
    }


    public static void main(String[] args) throws IOException {
        String path = thinkjava.JavaIo.Utils.Constants.hPBasic + "BufferedInputFile.java";
        System.out.println(read(path));
    }
}
