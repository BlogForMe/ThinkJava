package thinkjava.Demo.ArrayInit;

/**
 * Created by Jon on 2016/5/29.
 *
 */
public class NewVarArgs {
    static  void printArray(Object ...args){
        for (Object obj : args)
            System.out.println(obj + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        //Can take individual elements:
        printArray(new Integer(47) ,new Float(3.14),new Double(11.11));
        printArray(47,3.14,11,11);
        printArray("one" , "tow" , "three");
        printArray(new A(),new A(),new A());
        //Or an array:
        printArray(new Integer[]{1,2,3,4});
        printArray();  // Empty list is Ok
    }
}
