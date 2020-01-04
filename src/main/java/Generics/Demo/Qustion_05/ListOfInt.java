package Generics.Demo.Qustion_05;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jon on 17-1-15.
 * 15.11.1 任何基本类型 都不能作为类型参数
 */
public class ListOfInt {
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            li.add(i);
        for (int i : li)
            System.out.print(i + " ");
    }
}
