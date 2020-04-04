package thinkjava.JavaIo.Demo.ObjectSerialization_04;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Created by jon on 17-1-8.
 */
public class RevoverCADState {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(thinkjava.JavaIo.Utils.Constants.writePathU + "CADState.out"));
        //Read in the same order they were written:
        List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>) in.readObject();
        Line.deserializeStaticState(in);
        List<Shape> shapes = (List<Shape>) in.readObject();
        System.out.println(shapes);  //从输出可以看到line的color是没问题的
    }
}
