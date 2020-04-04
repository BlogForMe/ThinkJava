package thinkjava.InnerClass.demo.BasicInner;

/**
 * Created by Jon on 2016/6/7.
 * 10.3  使用.new
 * Creating an inner class directly using the new syntax;
 */
public class DotNew {
    public class Inner {
    }

    public static void main(String[] args) {
        DotNew dn = new DotNew();
        Inner dni = dn.new Inner();
    }
}
