package Generics.Exercise;

/**
 * Created by jon on 17-1-15.
 */
public class E25_Border {

    static <T extends SuperCat> void play(T arg) {
        System.out.println("Play()");
    }

    static <K extends SuperDog> void sing(K arg) {
        System.out.println("sing()");
    }

    public static void main(String[] args) {
        Border sc = new Border();
        play(sc);
        sing(sc);
    }
}


interface SuperCat {

}

interface SuperDog {

}

class Border implements SuperCat, SuperDog {

}