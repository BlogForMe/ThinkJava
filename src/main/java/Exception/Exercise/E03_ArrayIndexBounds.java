package Exception.Exercise;

/**
 * Created by jon on 17-5-25.
 */
public class E03_ArrayIndexBounds {
    public static void main(String[] args) {
        char[] array = new char[10];
        try {
            args[10] = "x";
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("e = " + e);
        }
    }
}
