package HoldingObject.Demo.StackAndSetMap;

import JavaIo.Demo.BasicIO_01.Constants;
import JavaIo.Demo.BasicIO_01.TextFile;

import java.util.TreeSet;

/**
 * Created by Jon on 2016/6/11.
 * 11.9 Set
 */
public class UniqueWords {
    public static void main(String[] args) {
        TreeSet<String> words = new TreeSet<String>(new TextFile(Constants.homepathW + "People","\\W+"));
        System.out.println(words);
    }
}
