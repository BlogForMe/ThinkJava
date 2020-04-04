package thinkjava.JavaIo.Exercise;

import thinkjava.JavaIo.Demo.BasicIO_01.BinaryFile;
import thinkjava.JavaIo.Utils.Constants;

import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2017/1/6.
 */
public class E19_BinaryFile {
    public static void main(String[] args) throws IOException {
        Map<Byte, Integer> bytesStat = new HashMap<>();

        for (Byte bt : BinaryFile.read(Constants.hPExercise + "E19_BinaryFile.java")) {
            Integer freq = bytesStat.get(bt);
            bytesStat.put(bt, freq == null ? 1 : freq + 1);
        }
        List<Byte> keys = Arrays.asList(bytesStat.keySet().toArray(new Byte[0]));
        Collections.sort(keys);
        for (Byte key : keys)
            System.out.println(key + " -> " + bytesStat.get(key));

    }
}
