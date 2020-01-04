package JavaIo.Demo.NewIO_02;

import net.mindview.util.Print;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * Created by jon on 16-4-3.
 * 18.10.45 缓冲区的细节
 * 对charbuffer中的字符进行编码和译码
 */
public class UsingBuffers {
    private static void symmetricScramble(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            buffer.mark();
            char c1 = buffer.get();
            char c2 = buffer.get();
            buffer.reset();
            buffer.put(c2).put(c1);
        }
    }

    public static void main(String[] args) {
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        Print.print(cb.rewind());

        symmetricScramble(cb);
        Print.print(cb.rewind());

        symmetricScramble(cb);
        Print.print(cb.rewind());


    }
}
