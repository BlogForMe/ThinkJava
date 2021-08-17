package algorlthm.learn.lagou;

import thinkjava.Demo.StackAndSetMap.Stack;

public class Gongjin04Exercise {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 3;
        Stack stack1 = new Stack();
        int n = 6;
//        if (n/k%2==0){
//
//        }
        for (int i = 1; i <= n; i++) {
            stack1.push(i);
            if (i % k == 0) {
                while (!stack1.empty()) {
                    System.out.print(stack1.pop());
                }
            }
        }


//        Stack test = new Stack();
//        while (!stack1.empty()) {
//            test.push(stack1.pop());
//        }
//        while (!test.empty()) {
//            System.out.print(test.pop());
//        }

    }

}
