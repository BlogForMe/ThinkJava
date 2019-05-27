package JavaIo.Exercise;

import JavaIo.Demo.BasicIO_01.Constants;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by jon on 16-4-5.
 * 练习25
 */
public class Exercise_tweenty_five {
    public static void main(String[] args) throws Exception {
        String[] arg = new String[2];
        arg[0] = Constants.pathNewIO + "Exercise_tweenty_five.java";
        arg[1] = Constants.homePath + "mytest.java";
        FileChannel
                in = new FileInputStream(arg[0]).getChannel(),
                out = new FileOutputStream(arg[1]).getChannel();
        ByteBuffer buffer = ByteBuffer.allocateDirect(Constants.BZSIZE);
        while (in.read(buffer) != -1) {
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }


    }
}
