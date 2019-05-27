package Generics.Demo.Qustion_05;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Created by jon on 17-1-15.
 */
public class NeedCasting {
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
//        List<Widget> shapes = (List<Widget>) in.readObject();
    }
}
