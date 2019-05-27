package JavaIo.Demo.ObjectSerialization_04;

import JavaIo.Demo.BasicIO_01.Constants;
import net.mindview.util.Print;

import java.io.*;

/**
 * Created by Jon on 2016/5/28.
 * 完整的保存和恢复一个 Externalizable
 */
public class Blip3 implements Externalizable {
    private int i;
    private String s; // No initialization

    public Blip3() {
        Print.print("Blip3 Constructor");
        //s , i not  initialized
    }

    public Blip3(String s, int i) {
        Print.print("Blip3(int i, String s)");
        this.i = i;
        this.s = s;
        //s&i  initialized only in non-default constructor
    }

    public String toString() {
        return s + i;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        Print.print("Blip3.writeExternal");
        //You must do thie:
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        Print.print("Blip3.readExternal");
        //You must do this:
        s = (String) in.readObject();
        i = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Print.print("Constructing objects:");
        Blip3 b3 = new Blip3("A String ", 47);
        Print.print(b3);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(JavaIo.Utils.Constants.writePathU + "Blip3.out"));
        Print.print("Saving object:");
        o.writeObject(b3);
        o.close();

        //Now get it back:
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(JavaIo.Utils.Constants.writePathU + "Blip3.out"));
        Print.print("Recovering b3:");
        b3 = (Blip3) in.readObject();
        Print.print(b3);
    }
}
