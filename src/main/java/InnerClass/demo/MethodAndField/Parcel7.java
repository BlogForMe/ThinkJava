package InnerClass.demo.MethodAndField;

import InnerClass.demo.BasicInner.Contents;

/**
 * Created by Jon on 2016/6/12.
 * 10.6匿名内部类
 * Retuning an instance of anonymous inner class.
 */
public class Parcel7 {
    public Contents contents() {
        return new Contents() {   // Insert a class definition
            private int i = 11;

            @Override
            public int value() {
                return i;
            }
        }; //Semicolon required in this case
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
    }
}
