package JavaIo.Demo.BasicIO_01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Created by jon on 16-4-3.
 * 18.10  FileChannel  数据copy
 */
public class TransferTo {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("arguments :sourcefile destfile");
        }

        String[] arg = new String[2];
        arg[0] = Constants.path+"ChannelCopy.java";
        arg[1] = Constants.homePath+"mytest.java";
        FileChannel
                in = new FileInputStream(arg[0]).getChannel(),
                out = new FileOutputStream(arg[1]).getChannel();
//        in.transferTo(0, in.size(), out);
         out.transferFrom(in,0,in.size());

    }
}
