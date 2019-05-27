package InnerClass.demo.MethodAndField;

import InnerClass.demo.BasicInner.Destination;

/**
 * Created by Jon on 2016/6/7.
 * Nesting a  class within a method
 */
public class Parcel5 {
    public Destination destination(String s) {
        class PDestination implements Destination {
            private String label;

            public PDestination(String label) {
                this.label = label;
            }

            @Override
            public String readLable() {
                return label;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tasmania");
        System.out.println(d.readLable());
    }
}
