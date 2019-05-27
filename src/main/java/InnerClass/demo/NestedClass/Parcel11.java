package InnerClass.demo.NestedClass;

import InnerClass.demo.BasicInner.Contents;
import InnerClass.demo.BasicInner.Destination;

import static InnerClass.demo.NestedClass.Parcel11.ParcelDestination.contents;
import static InnerClass.demo.NestedClass.Parcel11.ParcelDestination.destination;

/**
 * Created by Jon on 2016/6/12.
 * Nested classes (static inner classes).
 */
public class Parcel11 {
    private static class ParcelContents implements Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    protected static class ParcelDestination implements Destination {
        private String label;

        public ParcelDestination(String label) {
            this.label = label;
        }

        @Override
        public String readLable() {
            return label;
        }

        //Nested classes can contain other static elements:
        public static void f() {
        }

        static int x = 10;

        static class AnotherLevel {
            public static void f() {
            }

            static int x = 10;
        }

        public static Destination destination(String s) {
            return new ParcelDestination(s);
        }

        public static Contents contents() {
            return new ParcelContents();
        }
    }

    public static void main(String[] args) {
        Contents c = contents();
        Destination d = destination("Tasmania");
        ParcelDestination.AnotherLevel.f();
    }
}
