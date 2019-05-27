package JavaIo.Demo.NewIO_02;


import JavaIo.Utils.Constants;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by jon on 16-4-3.
 * 18.10
 */
public class ChannelCopy {
    public static void main(String[] args) throws Exception {
//        if (args.length != 2) {
//            System.out.println("arguments: sourcefile destfile");
//            System.exit(1);
//        }
        String[] arg = new String[2];
        arg[0] = Constants.homePathU + "Demo/NewIO/ChannelCopy.java";
        arg[1] = Constants.writePathU + "mytest.java";
        FileChannel
                in = new FileInputStream(arg[0]).getChannel(),
                out = new FileOutputStream(arg[1]).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(Constants.BZSIZE);
        while (in.read(buffer) != -1) {
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }


    }
}
