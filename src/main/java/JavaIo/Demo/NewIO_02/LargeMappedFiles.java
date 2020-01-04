package JavaIo.Demo.NewIO_02;

import JavaIo.Utils.Constants;
import net.mindview.util.Print;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by jon on 16-4-3.
 */
public class LargeMappedFiles {
    static int length = 0x8FFFFFF;  //128MB

    public static void main(String[] args) throws Exception {
        MappedByteBuffer out = new RandomAccessFile(Constants.writePathU + "test.dat", "rw").getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++)
            out.put((byte) 'x');

        Print.print("Finished writing");
        for (int i = length / 2; i < length / 2 + 6; i++) {
            Print.printnb((char) out.get(i));
        }

    }
}
