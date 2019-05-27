package JavaIo.Demo.ObjectSerialization_04;

import java.io.*;

/**
 * Created by Jon on 2016/5/28.
 */
public class SerialCtl implements Serializable {
    private String a;
    private transient String b;

    public SerialCtl(String b, String a) {
        this.a = "Not Transient  " + a;
        this.b = "Transient   " + b;
    }

    @Override
    public String toString() {
        return a + "\n" + b;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(b);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        b = (String) stream.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerialCtl sc = new SerialCtl("Test1", "Test2");
        System.out.println("Before:\n" + sc);

        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(buf);
        o.writeObject(sc);
        //Now get it back;

        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
        SerialCtl sc2 = (SerialCtl) in.readObject();
        System.out.println("AFTER:\n" + sc2);
    }

}
