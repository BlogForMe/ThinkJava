package InnerClass.demo.NestedClass;

/**
 * Created by Jon on 2016/6/12.
 * Two ways that a class can implement multiple interfaces.
 */

interface  A{}
interface  B{}
class  X implements  A,B{}
class  Y implements  A{
    B makeB(){
        // Anonymous inner class:
    return  new B(){};
    }
}
public class MultiInterfaces {
    static  void takesA(A a){}
    static  void takeB(B b){}

    public static void main(String[] args) {
      X   x  = new X();
       Y  y = new Y();
        takesA(x);
        takesA(y);
        takeB(x);
        takeB(y.makeB());
    }
}
