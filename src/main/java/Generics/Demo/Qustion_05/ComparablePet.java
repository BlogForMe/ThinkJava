package Generics.Demo.Qustion_05;

/**
 * Created by Administrator on 2017/1/16.
 * 15.11.5 基类劫持了接口
 */
public class ComparablePet implements Comparable<ComparablePet> {

    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}

//
//class  Cat extends  ComparablePet implements  Comparable<Cat>{
//    @Override
//    public int compareTo(ComparablePet o) {
//        return 0;
//    }
//}
