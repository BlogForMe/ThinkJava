package InnerClass.demo.MethodAndField;

import InnerClass.demo.BasicInner.Destination;

/**
 * Created by Jon on 2016/6/12.
 * An anonymous inner class that performs
 * initialization . A briefer version of Paecel5.java.
 */
public class Parcel9 {
    //Argument must be final to use inside
    //anonymous inner class:
    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest;
            @Override
            public String readLable() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania");
    }
}
