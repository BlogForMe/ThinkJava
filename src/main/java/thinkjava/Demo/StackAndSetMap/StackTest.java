package thinkjava.Demo.StackAndSetMap;

/**
 * Created by Jon on 2016/6/11.
 * 11.8 Stack
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        for ( String s:"My dog has fleas".split(" "))
            stack.push(s);
        while (!stack.empty())
            System.out.println(stack.pop() + " ");
    }
}
