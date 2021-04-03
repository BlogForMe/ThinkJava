package dreamgong;

public class BottomBorder {
    public static void main(String[] args) {
//        Plate<? super Fruit> plate = new Plate<Apple>();
//

    }
}


class Food {

}

class Fruit extends Food {
    protected Fruit() {

    }

     void whatName() {
        System.out.println("whatName    Fruit'");
    }
}

class Meat extends Food {
}

class Apple extends Fruit {
    @Override
    void whatName() {
//        super.whatName();
        System.out.println("whatName  Apple");
    }
}


class Banana extends Fruit {
}

class Pork extends Meat {
}

class Beef extends Meat {
}

class RedApple extends Apple {
}

class GreenApple extends Apple {
}
