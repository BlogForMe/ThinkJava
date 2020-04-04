package thinkjava.Generics.Exercise;

import thinkjava.Generics.Demo.basickGenerics_01.RandomList;
import thinkjava.net.mindview.util.CountingGenerator;
import thinkjava.net.mindview.util.Generator;

/**
 * Created by Administrator on 2017/1/9.
 */
public class E06_RandomList {
    private static void dm(RandomList<?> rs) {
        for (int i = 0; i < 11; i++)
            System.out.print(rs.select() + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        for (String s : ("The quick brown fox jumped over" + "the lazy brown dog").split(" "))
            rs.add(s);
        dm(rs);

        Generator<Integer> gi = new CountingGenerator.Integer();
        RandomList<Integer> ri = new RandomList<>();
        for (int i = 0; i < 11; i++)
            ri.add(gi.next());
        dm(ri);

    }
}
