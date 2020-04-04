package thinkjava.Generics.Demo.InterfaceAndMethod_02;

import thinkjava.net.mindview.util.Print;

import java.util.EnumSet;
import java.util.Set;

import static thinkjava.Generics.Demo.InterfaceAndMethod_02.Sets.*;

/**
 * Created by Jon on 2016/6/3.
 */
public class WatercolorSets {
    public static void main(String[] args) {
        /**
         * 下面方法返回 两个枚举之间的元素
         */
        EnumSet<Watercolors> set1 = EnumSet.range(Watercolors.BRILLIANT_RED, Watercolors.VIRIDIAN_HUE);

        EnumSet<Watercolors> set2 = EnumSet.range(Watercolors.CERULEAN_BLUE_HUE, Watercolors.BURNT_UMBER);
        Print.print("set1 : " + set1);
        System.out.println();
        Print.print("set2 : " + set2);
        System.out.println();
        Print.print("union(set1,set2): " + union(set1, set2));         //把set2添加到set1 去重
        System.out.println();
        Set<Watercolors> subset = intersection(set1, set2);         //获取set1和set2de交集
        Print.print("intersection(set1, set2)：  " + subset);
        System.out.println();
        Print.print("difference(set1,set2) :   " + difference(set2, subset));
        Print.print("complement(set1,set2):" + complement(set1, set2));
    }
}
