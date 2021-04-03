package datastruct.lagou;

import thinkjava.net.mindview.util.Stack;

public class Gongjin04 {
    public static void main(String[] args) {
        String s = "{[()()]}";

        System.out.println(isLegal(s));
    }

    private static String isLegal(String s) {
        Stack stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (isLeft(curr)) {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) {
                    return "非法";
                }
                char p = (char) stack.pop();
                if (!isPair(p, curr)) {
                    return "非法";
                }
            }
        }

        if (stack.empty()) {
            return "合法";
        } else {
            return "非法";
        }

    }

    private static boolean isLeft(char c) {
        if (c == '{' || c == '(' || c == '[') {
            return true;
        }
        return false;
    }

    private static boolean isPair(char p, char curr) {
        if ((p == '{' && curr == '}') || (p == '[' && curr == ']') || (p == '(' && curr == ')')) {
            return true;
        }
        return false;
    }
}
