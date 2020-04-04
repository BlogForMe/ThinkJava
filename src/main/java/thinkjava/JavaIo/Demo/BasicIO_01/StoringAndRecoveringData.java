package thinkjava.JavaIo.Demo.BasicIO_01;

import java.io.*;

/**
 * Created by jon on 16-4-2.
 * 存储和恢复数据
 * 18.6.5
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        String path = Constants.homePath + "date.txt";

        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
        out.writeDouble(3.14159);
        out.writeUTF("That was Pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();

        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(path)));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());

    }
}
