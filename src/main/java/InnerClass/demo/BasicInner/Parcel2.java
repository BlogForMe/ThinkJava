package InnerClass.demo.BasicInner;

/**
 * Created by Jon on 2016/6/6.
 * 10.1 内部类
 * Returning a reference to an inner class
 */
public class Parcel2 {
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

        String readLine() {
            return label;
        }
    }

    public Destination to(String s) {
        return new Destination(s);
    }

    public Contents contents() {
        return new Contents();
    }

    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = to(dest);
        System.out.println(d.readLine());
    }


    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        p.ship("Tasmania");
        Parcel2 q = new Parcel2();
        //Defining references to inner classes:
        Contents c = q.contents();
        Destination d = q.to("Borneo");

    }

}
