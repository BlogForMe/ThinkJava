package JavaIo.Exercise;

import net.mindview.util.Print;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by jon on 17-1-8.
 *
 */
public class E28_BlipCheck {
    public static void main(String[] args) {

    }
}


class BlipCheck implements Externalizable {
    public BlipCheck() {
        Print.print("Blip1 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        Print.print("BlipCheck.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        Print.print("BlipCheck.readExternal");
    }
}

class Blip1 implements Externalizable {
    Blip1() {
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