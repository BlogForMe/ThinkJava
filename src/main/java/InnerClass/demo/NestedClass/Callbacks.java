package InnerClass.demo.NestedClass;

import net.mindview.util.Print;

/**
 * Created by Jon on 2016/6/12.
 * Using inner classes for callbacks
 *
 * 有些不理解！！！！！  没静下来
 */

interface  Incrementable{
    void increment();
}

//Very simple to just implement the interface:
class  Calleel implements  Incrementable{
   private  int i=0;
    @Override
    public void increment() {
        i++;
        Print.print(i);
    }
}

class  MyIncrement{
    public  void  increment(){
        Print.print("Other operation");
    }
    static  void f(MyIncrement mi){
        mi.increment();
    }
}

//If your class must implement increment() in
//some other way, you must use an inner class;
class  Callee2 extends  MyIncrement{
    private  int i=0;
    public  void increment(){
        super.increment();
        i++;
        Print.print(i);
    }
    private  class  Closure implements  Incrementable{

        @Override
        public void increment() {
            //Specify outer-class method,otherwise
            //you'd get an infinite recursion;
            Callee2.this.increment();
        }
    }
    Incrementable getCallBackReference(){
        return  new Closure();
    }
}
class Caller{
    private  Incrementable callbackReference;

    public Caller(Incrementable cbh) {
        this.callbackReference = cbh;
    }
    void go(){callbackReference.increment();}
}
public class Callbacks {
    public static void main(String[] args) {
        Calleel c1 = new Calleel();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallBackReference());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
