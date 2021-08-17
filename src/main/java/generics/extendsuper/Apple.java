package generics.extendsuper;

public class Apple extends Fruit {
    @Override
    void whatName() {
//        super.whatName();
        System.out.println("whatName  Apple");
    }
}
