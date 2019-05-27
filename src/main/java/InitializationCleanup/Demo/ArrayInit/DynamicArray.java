package InitializationCleanup.Demo.ArrayInit;


/**
 * Created by Jon on 2016/5/29.
 * Array initialization
 */
public class DynamicArray {
    public static void main(String[] args) {
        Other.main(new String[]{"fiddle", "de", "dum"});
    }
}

class Other {
    public static void main(String[] args) {
        for (String s : args)
            System.out.print(s + "  ");
    }
}