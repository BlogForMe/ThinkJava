import java.util.*;

public class Test {
    public static void main(String[] args) {

        boolean ssd = false ^ true;
        System.out.println(ssd);

//        Integer i1 = 56;
//        Integer i2 = 56;
//        Integer i3 = 129;
//        Integer i4 = 129;
//        System.out.println(i1==i2);
//        System.out.println(i3==i4);


//        String s1 = "小争哥";
//        String s2 = "小争哥";
//        String s3 = new String("小争哥");
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);

//        Integer a = 1;
//        Integer b = 2;
//        Integer c = 3;
//        Integer d = 3;
//        Integer e = 321;
//        Integer f = 321;
//        Long g = 3L;
//        System.out.println(c==d);
//        System.out.println(e==f);
//        System.out.println(c==(a+b));
//        System.out.println(c.equals(a+b));
//        System.out.println(g ==(a+b));
//        System.out.println(g.equals(a+b));

//        byte,shrot,char 计算 会自动转换为int，
//        int 与long 计算 会自动转为long
//        比较会让Interger对象强转成Long对象，然后就是用的LongCache了
//        g.longValue() == (long)(a.intValue() + b.intValue())


//        List<Integer> list = new ArrayList<>();
//        list.add(3);
//        list.add(8);
//        list.add(2);
//
//        Iterator<Integer> iter1 = list.iterator();//snapshot: 3, 8, 2
//        list.remove(new Integer(2));//list：3, 8
//        Iterator<Integer> iter2 = list.iterator();//snapshot: 3, 8
//        list.remove(new Integer(3));//list：8
//        Iterator<Integer> iter3 = list.iterator();//snapshot: 3
//
//// 输出结果：3 8 2
//        while (iter1.hasNext()) {
//            System.out.print(iter1.next() + " ");
//        }
//        System.out.println();
//
//// 输出结果：3 8
//        while (iter2.hasNext()) {
//            System.out.print(iter1.next() + " ");
//        }
//        System.out.println();
//
//// 输出结果：8
//        while (iter3.hasNext()) {
//            System.out.print(iter1.next() + " ");
//        }
//        System.out.println();


        int i =1;
        do {
            System.out.println(i);
            i++;
        }while (i<0);

    }
}
