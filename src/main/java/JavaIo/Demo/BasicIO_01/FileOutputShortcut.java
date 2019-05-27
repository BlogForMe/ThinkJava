package JavaIo.Demo.BasicIO_01;

import JavaIo.Utils.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * Created by Administrator on 2017/1/5.
 */
public class FileOutputShortcut {
    static String file = "FileOutputShortcut.out";

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(Constants.hPBasic + "FileOutputShortcut.java")));

        //Here's the shortcut
        PrintWriter out = new PrintWriter(Constants.writePathW + file);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        //Show the stored file:
        System.out.println(BufferedInputFile.read(Constants.writePathW + file));
    }

}
