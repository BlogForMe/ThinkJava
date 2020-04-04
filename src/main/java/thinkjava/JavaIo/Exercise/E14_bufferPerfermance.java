package thinkjava.JavaIo.Exercise;

import thinkjava.JavaIo.Utils.Constants;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/1/5.
 */
public class E14_bufferPerfermance {
    public static void main(String[] args) throws IOException {
        LinkedList<String> list = E07_FileLinkedList.readLinked(Constants.hPExercise + "E14_bufferPerfermance.java");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(Constants.writePathW + "E14_bufferPerfermance")));
        int lineCount = 1;
        long t1 = System.currentTimeMillis();
        for (String s : list) {
            for (int i = 0; i < 10000; i++)
                out.println(lineCount++ + s);
        }
        out.close();
        long t2 = System.currentTimeMillis();
        System.out.println("buffered: " + (t2 - t1));

        out = new PrintWriter((new FileWriter(Constants.writePathW + "E14_bufferPerfermance")));
        lineCount = 1;
        t1 = System.currentTimeMillis();
        for (String s : list) {
            for (int i = 0; i < 10000; i++)
                out.println(lineCount++ + s);
        }
        t2 = System.currentTimeMillis();
        System.out.println("unbuffered: " + (t2 - t1));
    }
}
