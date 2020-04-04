package thinkjava.JavaIo.Demo.NewIO_02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Created by jon on 17-1-7.
 * 新IO 用transferTo() transferFrom() 将一个通道和另一个通道相连
 */
public class TransferTo {
    public static void main(String[] args) throws Exception {
        FileChannel
                in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();
        in.transferTo(0, in.size(), out);
        //or : out.transferfrom(in,0,in.size);
    }
}
