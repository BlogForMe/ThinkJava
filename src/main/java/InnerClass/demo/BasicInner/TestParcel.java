package InnerClass.demo.BasicInner;

/**
 * Created by Jon on 2016/6/7.
 * 10.4 内部类与向上转型
 */

class Parcel4 {
    private class PContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination {
        private String label;

        public PDestination(String label) {
            this.label = label;
        }

        @Override
        public String readLable() {
            return label;
        }
    }

    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }
}


public class TestParcel {
    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents c = p.contents();
        Destination d = p.destination("Tasmania");
        System.out.println(d.readLable());
        Parcel4.PDestination pd = p.new PDestination("你好");
        System.out.println(pd.readLable());

        // Illegal --can't access private class;
//        p.new PContents();
    }
}
