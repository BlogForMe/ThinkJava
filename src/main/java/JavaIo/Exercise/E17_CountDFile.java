package JavaIo.Exercise;

import JavaIo.Demo.BasicIO_01.TextFile;
import JavaIo.Utils.Constants;

import java.util.*;

/**
 * Created by Administrator on 2017/1/6.
 */
public class E17_CountDFile {
    public static void main(String[] args) {
        Map<Character, Integer> charsState = new HashMap<>();
        for (String word : new TextFile(Constants.hPExercise + "E17_CountDFile.java"))
            for (int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);//拿到i位置上的字符
                Integer freq = charsState.get(ch);
                charsState.put(ch, freq == null ? 1 : freq + 1);
            }
        List<Character> keys = Arrays.asList(charsState.keySet().toArray(new Character[0]));
        Collections.sort(keys);
        for (Character key : keys)
            System.out.println(key + " => " + charsState.get(key));
    }
}


