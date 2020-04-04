package thinkjava.Exception.Exercise;


public class E02_E {
    public static void main(String[] args) {
        String s = null;
        //Causes a NullPointerException:
        try {
            s.toString();
        } catch (Exception e) {
            System.out.println("Caught exception " + e);
        }
    }
}
