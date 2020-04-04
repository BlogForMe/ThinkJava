package thinkjava.JavaIo.Demo.NewIO_02;


import thinkjava.JavaIo.Utils.Constants;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by jon on 16-4-3.
 * 18.10.1转换数据
 */
public class BufferToText {
    public static void main(String[] args) throws Exception {
        ByteBuffer buff = ByteBuffer.allocate(Constants.BZSIZE);

//        One part
        FileChannel fc = new FileOutputStream(Constants.writePathU + "data2.txt").getChannel();
//        fc.write(ByteBuffer.wrap("Some text  呵呵".getBytes()));
//        fc.close();
//
//        fc = new FileInputStream(Constants.writePathU + "data2.txt").getChannel();
//        fc.read(buff);
//        buff.flip();
//        //Doesn't work
//        System.out.println(buff.asCharBuffer());  //打印出乱码
//        //Decode using this system's default Charset:
//        buff.rewind();
//        String encoding = System.getProperty("file.encoding");
//        System.out.println("Decoded using" + encoding + ":" + Charset.forName(encoding).decode(buff));


//              Second Part
//        or ,we could encode with something that will print
//        fc = new FileOutputStream(Constants.writePathU + "data2.txt").getChannel();
//        fc.write(ByteBuffer.wrap("some ohter text 宝贝".getBytes("UTF-16BE")));
//        fc.close();
//////        //Now try reading agian
//        fc = new FileInputStream(Constants.writePathU + "data2.txt").getChannel();
//        buff.clear();
//        fc.read(buff);
//        buff.flip();
//        System.out.println(buff.asCharBuffer());


//         Third Part
        //use a charbuffer to write through
        fc = new FileOutputStream(Constants.writePathU + "data2.txt").getChannel();
        buff = ByteBuffer.allocate(60); //more than need
        buff.asCharBuffer().put("some hengheng 玥玥宝贝");
        fc.write(buff);
        fc.close();
//        //read and display
//
        fc = new FileInputStream(Constants.writePathU + "data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
    }

}
