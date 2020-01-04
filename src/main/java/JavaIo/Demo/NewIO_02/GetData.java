package JavaIo.Demo.NewIO_02;

import JavaIo.Demo.BasicIO_01.Constants;
import net.mindview.util.Print;

import java.nio.ByteBuffer;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * Created by jon on 16-4-3.
 * 18.10.2  获取基本类型
 */
public class GetData {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(Constants.BZSIZE);
        //Alloction automatically zeroes the ByteBuffer;
        int i = 0;
        while (i++ < bb.limit())
            if (bb.get() != 0)
                print("nonzero");
        print("i=" + i);
        bb.rewind();
//        //store and read a char array
        bb.asCharBuffer().put("Howdy!");
        char c;
        while ((c = bb.getChar()) != 0)
            printnb(c + " ");
//
        print();
//
//
        bb.rewind();
//
//        //    store and read a short:
        bb.asShortBuffer().put((short) 471142);
        print(bb.getShort());
        bb.rewind();
//
//        //store and read an int
        bb.asIntBuffer().put(99471142);
        Print.print(bb.getInt());
        bb.rewind();
//        //store aand read a long
        bb.asLongBuffer().put(99471142);
        Print.print(bb.getLong());
        bb.rewind();
//
//        //stoe and read a float;
        bb.asFloatBuffer().put(99471142);
        Print.print(bb.getFloat());
        bb.rewind();
//
//        //store and read a double
        bb.asDoubleBuffer().put(99471142);
        Print.print(bb.getDouble());
        bb.rewind();

    }
}
