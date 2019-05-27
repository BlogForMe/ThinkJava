package HoldingObject.Demo.StackAndSetMap;

/**
 * Created by Jon on 2016/6/11.
 * 11.8 Stack
 */
public class StackCollision {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        for (String s :"My dog haa  fleas".split(" "))
            stack.push(s);
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
        System.out.println();
        Stack<String> stack2 = new Stack<String>();
        for (String s : "My dog has fleas".split(" "))
            stack2.push(s);
        while (!stack2.empty())
            System.out.print(stack2.pop() + " ");
    }
}
