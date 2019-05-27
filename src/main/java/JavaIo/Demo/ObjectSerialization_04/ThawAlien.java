package JavaIo.Demo.ObjectSerialization_04;

import JavaIo.Demo.BasicIO_01.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Created by Jon on 2016/5/28.
 * 18.12.1寻找类
 */
public class ThawAlien {
    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(Constants.homepathW + "X.file")));
        Object mystery = in.readObject();
        System.out.println(mystery.getClass());
    }
}

