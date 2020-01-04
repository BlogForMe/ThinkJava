package JavaIo.Demo.NewIO_02;


import JavaIo.Utils.Constants;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by jon on 16-4-3.
 * 18.10
 */
public class GetChannel {
    public static final int BZSIZE = 1024;

    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream(Constants.writePathU + "GetChannel.txt").getChannel();
        fc.write(ByteBuffer.wrap("some text".getBytes()));
        fc.close();
        fc = new RandomAccessFile(Constants.writePathU + "GetChannel.txt", "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("some more".getBytes()));
        fc.close();

        //read the file
        fc = new FileInputStream(Constants.writePathU + "GetChannel.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BZSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining()) {
            System.out.print((char) buff.get());
        }


    }
}
