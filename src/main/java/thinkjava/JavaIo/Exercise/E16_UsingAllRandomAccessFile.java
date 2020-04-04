package thinkjava.JavaIo.Exercise;

import thinkjava.JavaIo.Utils.Constants;
import thinkjava.net.mindview.util.Print;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by jon on 17-1-6.
 */
public class E16_UsingAllRandomAccessFile {
    static String file = Constants.writePathU + "rtest.dat";

    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        Print.print(rf.readBoolean());
        Print.print(rf.readByte());
        Print.print(rf.readUnsignedByte());
        Print.print(rf.readChar());
        Print.print(rf.readFloat());
        Print.print(rf.readLong());
        Print.print(rf.readInt());
        Print.print(rf.readShort());
        Print.print(rf.readUnsignedShort());
        Print.print(rf.readDouble());
        Print.print(rf.readUTF());
        rf.close();

    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        rf.writeBoolean(true);
        rf.writeByte(100);
        rf.writeByte(255);
        rf.writeChar('A');
        rf.writeFloat(1.41413f);
        rf.writeLong(10000000000L);
        rf.writeInt(100000);
        rf.writeShort(30000);
        rf.writeShort(65535);
        rf.writeDouble(4.14159);
        rf.writeUTF("The end of the file");
        rf.close();
        display();

        rf = new RandomAccessFile(file, "rw");
        rf.seek(3); //1 boolean +2 bytes
        rf.writeChar('B');
        rf.close();
        display();
    }
}
