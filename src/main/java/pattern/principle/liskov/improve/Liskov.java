package pattern.principle.liskov.improve;

public class Liskov {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("11-3=" + a.func1(11, 3));
        System.out.println("1-8=" + a.func1(1, 8));

        System.out.println("---------------");
        B b = new B();
        //因为B类不再继承A类，因此调用者，不会再func1求减法
        System.out.println("11+3=" + b.func1(11, 3));
        System.out.println("1+8=" + b.func1(1, 8));
        System.out.println("11+3+9=" + b.func2(11, 3));


        //使用组合仍然可以使用A类相关方法
        System.out.println("11-3=" + b.func3(11, 3));

    }
}
 class  Base{
    //把更基础的方法和成员写到Base类中
}

class A extends Base {
    public int func1(int num1, int num2) {
        return num1 - num2;
    }


}

class B extends Base {
    //如果B需要使用A类的方法，使用组合关系
    private A a = new A();
    //没意识到 重写了该方法
    public int func1(int num1, int num2) {
        return num1 + num2;
    }

    public int func2(int a, int b) {
        return func1(a, b) +9;
    }

    public int func3(int a,int b){
        return this.a.func1(a,b);
    }
}
