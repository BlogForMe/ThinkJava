package thinkjava.Generics.Exercise;


/**
 * Created by jon on 17-1-15.
 * 抄的
 */
public class E26_CovariantArrays2 {
    public static void main(String[] args) {
        Number[] nums = new Integer[10];
        nums[0] = Integer.valueOf(1);


        nums[1] = new Float(1.0);


    }
}
