package JavaIo.Exercise;

import JavaIo.Utils.Constants;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;

import static JavaIo.Exercise.E07_FileLinkedList.readLinked;

/**
 * Created by Administrator on 2017/1/5.
 */
public class E12_LineWrite {
    public static void main(String[] args) throws IOException {
        //Constants.hPExercise + "E08_argsInput.java"
        if (args.length == 0) {
            System.err.println("Usage: java E08_argsInput file");
            return;
        }
        LinkedList<String> lList = readLinked(Constants.hPExercise + args[0]);
        PrintWriter out = new PrintWriter(Constants.writePathW + "E12_LineWrite.out");
        int lineCount = lList.size();
        for (ListIterator<String> it = lList.listIterator(lList.size()); it.hasPrevious(); ) {  //逆序运算
            out.println(lineCount-- + ": " + it.previous());
//            System.out.println(it.previous());
        }
        out.close();
    }
}
