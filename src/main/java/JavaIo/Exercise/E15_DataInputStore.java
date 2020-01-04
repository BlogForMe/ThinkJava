package JavaIo.Exercise;


import JavaIo.Utils.Constants;
import net.mindview.util.Print;

import java.io.*;

/**
 * Created by jon on 17-1-5.
 */
public class E15_DataInputStore {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(Constants.writePathU + "data.txt")));

        out.writeBoolean(true);
        out.writeByte(100);
        out.writeByte(255);
        out.writeChar('A');
        out.writeUTF("That waw pi");
        out.close();
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(Constants.writePathU + "data.txt")));
        Print.print(in.readBoolean());
        Print.print(in.readByte());
        Print.print(in.readUnsignedByte());
        Print.print(in.readChar());
        Print.print(in.readUTF());


    }

}
