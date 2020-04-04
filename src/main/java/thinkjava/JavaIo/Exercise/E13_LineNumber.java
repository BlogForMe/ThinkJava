package thinkjava.JavaIo.Exercise;

import thinkjava.JavaIo.Demo.BasicIO_01.BufferedInputFile;
import thinkjava.JavaIo.Utils.Constants;

import java.io.*;

/**
 * Created by Administrator on 2017/1/5.
 */
public class E13_LineNumber {
    public static void main(String[] args) throws IOException {
        LineNumberReader in = new LineNumberReader(new StringReader(BufferedInputFile.read(Constants.hPExercise + "E13_LineNumber.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(Constants.writePathW + "E13_LineNumber.out")));
        String s;
        while ((s = in.readLine()) != null)
            out.println(in.getLineNumber() + ": " + s);
        out.close();
        //Show the stored file
        System.out.println(BufferedInputFile.read(Constants.hPExercise + "E13_LineNumber.java"));
    }
}
