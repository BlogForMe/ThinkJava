package thinkjava.JavaIo.Demo.ObjectSerialization_04;

import thinkjava.JavaIo.Demo.BasicIO_01.Constants;
import thinkjava.net.mindview.util.Print;

import java.io.*;

/**
 * Created by Jon on 2016/5/28.
 * 18.12.2 序列化的控制
 */
class Blip1 implements Externalizable {
    public Blip1() {
        Print.print("Blip1 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        Print.print("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        Print.print("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable {
    Blip2() {
        Print.print("Blip2 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        Print.print("Blip2.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        Print.print("Blip2.readExternal");
    }
}

public class Blips {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Print.print("Constructing objects:");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(Constants.homepathW + "Blips.out"));
        Print.print("Saving objects:");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();
        //Now get them back:
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(Constants.homepathW + "Blips.out"));
        Print.print("Recovering b1");
        b1 = (Blip1) in.readObject();
        //oops ! Throws an exception:
//        Print.print("Recovering b2");
//        b2 = (Blip2) in.readObject();

    }
}

