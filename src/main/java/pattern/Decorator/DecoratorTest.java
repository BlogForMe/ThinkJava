package pattern.Decorator;

public class DecoratorTest {
    public static void main(String[] args) {

//        ConcreateComponent2 concreateComponent1 = new ConcreateComponent2(new ConcreateComponent1(new ConcreateComponent()));
//        concreateComponent1.operation();

        new ConcreteComponent1(new ConcreteComponent()).operation();

    }


}


interface Component{
    void operation();
}

// 具体类
class ConcreteComponent implements  Component{
    @Override
    public void operation() {
        System.out.println("拍照");
    }
}

//对具体类的拓展
class ConcreteComponent1 implements  Component {

    private Component component;
    public ConcreteComponent1(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        System.out.println("美颜");
        component.operation();
    }
}


/*
abstract class Decorator implements Component{
    Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

//对具体类的拓展
class ConcreateComponent1 extends  Decorator{

    public ConcreateComponent1(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("美颜");
        super.operation();
    }
}

class ConcreateComponent2 extends  Decorator{

    public ConcreateComponent2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("呵呵");
        super.operation();
    }
}*/
