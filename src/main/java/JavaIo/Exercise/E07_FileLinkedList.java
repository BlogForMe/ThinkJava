package JavaIo.Exercise;


import JavaIo.Utils.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Administrator on 2017/1/5.
 */
public class E07_FileLinkedList {
    public static LinkedList<String> readLinked(String filePath) {
        LinkedList<String> ll = new LinkedList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(filePath));
            String s;
            while ((s = in.readLine()) != null) {
                ll.add(s);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ll;
    }

    public static void main(String[] args) {
        LinkedList<String> lList = readLinked(Constants.hPExercise + "E07_FileLinkedList.java");
        for (ListIterator<String> it = lList.listIterator(lList.size()); it.hasPrevious(); )  //逆序运算
            System.out.println(it.previous());
    }
}
