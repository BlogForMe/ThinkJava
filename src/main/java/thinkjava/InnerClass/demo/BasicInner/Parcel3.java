package thinkjava.InnerClass.demo.BasicInner;

/**
 * Created by Jon on 2016/6/7.
 * 10.3   .new 应用于Parcel示例
 * <p>
 * Using .new to create instances of inner classes.
 */
public class Parcel3 {
    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        public Destination(String label) {
            this.label = label;
        }

        String readLabel() {
            return label;
        }
    }

    public static void main(String[] args) {
        Parcel3 p = new Parcel3();
        //Must use instance of outer class
        //to create an instance of the inner class;
        Contents c = p.new Contents();
        Destination d = p.new Destination("Tasmania");
        System.out.println(d.readLabel());
    }
}
