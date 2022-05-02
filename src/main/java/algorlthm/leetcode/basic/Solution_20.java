package algorlthm.leetcode.basic;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class Solution_20 {
    //官方解法更清晰
    public boolean isValid(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c == '(') || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                boolean p1 = (c == ')' && (char) stack.peek() == '(');

                boolean p2 = (c == ']' && (char) stack.peek() == '[');
                boolean p3 = (c == '}' && (char) stack.peek() == '{');
                if (p1 || p2 || p3) {
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution_20 solution = new Solution_20();
        assertEquals(true,solution.isValid("()"));
        assertEquals(true,solution.isValid("()[]{}"));
        assertEquals(false,solution.isValid("(]"));
        assertEquals(false,solution.isValid("([)]"));
        assertEquals(true,solution.isValid("{[]}"));
        assertEquals(false,solution.isValid("]"));
        assertEquals(false, solution.isValid("(])"));
    }
}
