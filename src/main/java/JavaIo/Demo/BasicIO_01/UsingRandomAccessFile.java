package JavaIo.Demo.BasicIO_01;

import JavaIo.Utils.Constants;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by jon on 16-4-2.
 * 我的理解是这个是按字节长度读取的，写入多长的字节，后面也按照多长的字节读取
 */
public class UsingRandomAccessFile {
    static String file = Constants.writePathU + "rtest.dat";

    static void display() throws IOException {
        RandomAccessFile fr = new RandomAccessFile(file, "r");
        for (int i = 0; i < 7; i++)
            System.out.println("Value " + " : " + fr.readDouble());
        System.out.println(fr.readUTF());
        fr.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++)
            rf.writeDouble(i * 1.414);
        rf.writeUTF("The end of the file");
        rf.close();
        display();
        rf = new RandomAccessFile(file, "rw");
        rf.seek(5 * 8);
        rf.writeDouble(47.0001);
        rf.close();
        display();

    }
}
