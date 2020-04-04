package thinkjava.JavaIo.Exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jon on 17-1-8.
 */
public class E30_CADState {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        ArrayList<Shape1> shapes = new ArrayList<>();
        //Make some shapes:
        for (int i = 0; i < 10; i++)
            shapes.add(Shape1.randomFactory());

        //Set  all the static colors to GREEN;
        for (int i = 0; i < 10; i++)
            (shapes.get(i)).setColor(Shape1.GREEN);
        //SAVE THE STATE VECTOR:
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(thinkjava.JavaIo.Utils.Constants.writePathU + "CADState.out"));
        Circle1.serializeStaticState(out);
        Square1.serializeStaticState(out);
        Line1.serializeStaticState(out);
        out.writeObject(shapes);


        ObjectInputStream in = new ObjectInputStream(new FileInputStream(thinkjava.JavaIo.Utils.Constants.writePathU + "CADState.out"));
        Circle1.deserializeStaticState(in);
        Square1.deserializeStaticState(in);
        Line1.deserializeStaticState(in);
//        //Display the shapes:
        List<Shape1> shapess = (List<Shape1>) in.readObject();
        System.out.println(shapess);
    }
}


abstract class Shape1 implements Serializable {
    public static final int RED = 1, BLUE = 2, GREEN = 3;
    private static int color = RED;
    private int xPos, yPos, dimension;
    private static Random rand = new Random(47);
    private static int counter = 0;

    public abstract void setColor(int newColor);

    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }

    public abstract int getColor();

    public Shape1(int xPos, int yPos, int dimension) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return getClass() + "  color[" + getColor() + "] xPos[" + xPos
                + "] yPos[" + yPos + "] dim[" + dimension + "]\n";
    }

    public static Shape1 randomFactory() {
        int xVal = rand.nextInt(100);
        int yVal = rand.nextInt(100);
        int dim = rand.nextInt(100);
        switch (counter++ % 3) {
            default:
            case 0:
                return new Circle1(xVal, yVal, dim);
            case 1:
                return new Square1(xVal, yVal, dim);
            case 2:
                return new Line1(xVal, yVal, dim);

        }
    }
}

class Circle1 extends Shape1 {
    private static int color = RED;

    public Circle1(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
    }

    @Override
    public void setColor(int newColor) {
        this.color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}

class Square1 extends Shape1 {
    private static int color;

    public Square1(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
        color = RED;
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}

class Line1 extends Shape1 {
    private static int color;


    public Line1(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}