package generics.extendsuper;

public class UpBorder {
    public static void main(String[] args) {
//        Plate<Fruit> p = new Plate<Apple>(new Apple());
//        Plate<? extends  Fruit> p = new Plate<Apple>(new Apple());
        Plate<? extends  Fruit> p = new Plate<>();
//        p.set(new Fruit());
//        p.set(new Apple());
//        System.out.println(p.get());
//        p.set(new GreenApple());
    }
}


class Plate<T> {
    public Plate() {
    }

    T item;

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


