package generics;
//https://noteforme.github.io/2018/04/16/Generics/
public class generic{
    public static void main(String[] args) {
        Plate<Fruit> p = new Plate(new Apple());
//        p.set(new Fruit());
//        p.set(new Apple());
//        p.set(new Food());
        Plate<? super  Fruit> pF = new Plate<>();
        pF.set(new Apple());
        Object fe = pF.get();
//        pF.set(new Food());
    }
}

class Food{

}
class Fruit extends  Food{
}

class Apple extends Fruit {
}

class Plate<T> {
    T item;

    public Plate() {
    }
    public Plate(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }

    public void set(T item) {
        this.item = item;
    }
}



