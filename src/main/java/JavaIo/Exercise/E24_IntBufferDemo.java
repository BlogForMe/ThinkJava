package JavaIo.Exercise;

import JavaIo.Utils.Constants;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

/**
 * Created by jon on 17-1-7.
 */
public class E24_IntBufferDemo {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(Constants.BZSIZE);
        DoubleBuffer ib = bb.asDoubleBuffer();
        //store an array of int;
        ib.put(new double[]{11, 42, 47, 99, 143, 811, 1016});
        //absulute location read and write;
        System.out.println(ib.get(3));
        ib.put(3, 1811);
        //setting a  new limit before rewinding the buffer
        ib.flip();
        while (ib.hasRemaining()) {
            double i = ib.get();
            System.out.println(i);
        }

    }
}
