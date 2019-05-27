package InitializationCleanup.Demo;

import net.mindview.util.Print;

/**
 * Created by Jon on 2016/5/29.
 * 5.6成员
 */
public class InitialValues {
    boolean t;
    char c;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    InitialValues reference;
    void printInitialValues(){
        Print.print("Dta type  Initial value");
        Print.print("boolean  " +t);
        Print.print("char  [" + c + "]");
        Print.print("byte   " + b);
        Print.print("short   " + s);
        Print.print("int " + i );
        Print.print("long   " + l);
        Print.print("float "  + f);
        Print.print("double    " + d);
        Print.print("reference    " + reference);
    }

    public static void main(String[] args) {
        InitialValues iv = new InitialValues();
        iv.printInitialValues();


    }
}
