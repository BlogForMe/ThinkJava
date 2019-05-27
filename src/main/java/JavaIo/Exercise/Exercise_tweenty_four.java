package JavaIo.Exercise;

import JavaIo.Demo.BasicIO_01.Constants;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

/**
 * Created by jon on 16-4-3.
 * 练习24
 */
public class Exercise_tweenty_four {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(Constants.BZSIZE);
        DoubleBuffer db = bb.asDoubleBuffer();
        //store an array of double
        db.put(new double[]{1.1,4.2,4.7,9.9,14.3,81.1,101.6});
        //Absolute a new limit before rewinding the buffer
        db.flip();
        while (db.hasRemaining())
            System.out.println(db.get());

    }
}
