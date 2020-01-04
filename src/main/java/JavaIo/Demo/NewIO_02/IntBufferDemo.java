package JavaIo.Demo.NewIO_02;

import JavaIo.Demo.BasicIO_01.Constants;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * Created by jon on 16-4-3.
 * 18.10.3  视图缓冲器
 */
public class IntBufferDemo {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(Constants.BZSIZE);
        IntBuffer ib = bb.asIntBuffer();
        //store an array of int;
        ib.put(new int[]{11, 42, 47, 99, 143, 811, 1016});
        //absulute location read and write;
        System.out.println(ib.get(3));
        ib.put(3,1811);
        //setting a  new limit before rewinding the buffer
        ib.flip();
        while (ib.hasRemaining()){
            int i = ib.get();
            System.out.println(i);
        }

    }
}
