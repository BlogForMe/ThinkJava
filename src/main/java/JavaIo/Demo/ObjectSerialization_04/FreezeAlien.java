package JavaIo.Demo.ObjectSerialization_04;

import JavaIo.Demo.BasicIO_01.Constants;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * A serializable class
 * <p>
 * 18.12.1  寻找类
 */
class Alien implements Serializable {
};


/**
 * Created by Jon on 2016/5/28.
 * Create a serialized output file
 */

public class FreezeAlien {
    public static void main(String[] args) throws Exception {
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(Constants.homepathW + "X.file"));
        Alien quellek = new Alien();
        out.writeObject(quellek);
    }

}
