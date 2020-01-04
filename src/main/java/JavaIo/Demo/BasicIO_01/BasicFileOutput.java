package JavaIo.Demo.BasicIO_01;

import JavaIo.Utils.Constants;

import java.io.*;

/**
 * Created by Administrator on 2017/1/5.
 */
public class BasicFileOutput {
    static String file = "BasicFileOutput.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(Constants.hPBasic + "BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(Constants.writePathW + "BasicFileOutput.out")));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null)
            out.println(lineCount++ + ": " + s);
        out.close();
        //Show the stored file
        System.out.println(BufferedInputFile.read(Constants.hPBasic + "BasicFileOutput.java"));
    }
}
