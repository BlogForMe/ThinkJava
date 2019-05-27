package JavaIo.Demo.NewIO_02;

import net.mindview.util.Print;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * Created by jon on 16-4-3.
 * 18.10.3 字节存放次序
 */
public class Endians {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        bb.asCharBuffer().put("abcdef");
        Print.print(Arrays.toString(bb.array()));
        bb.rewind();

        //高位优先
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        Print.print(Arrays.toString(bb.array()));
        bb.rewind();

        //低位优先
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        Print.print(Arrays.toString(bb.array()));


    }
}
