package pattern.uml.association;

// computer对象创建moniter,mouse创建， computer销毁也跟着销毁。
public class Computer {
    private Moniter moniter = new Moniter(); //moniter可以和computer不能分离
    private Mouse mouse = new Mouse();//mouse可以和computer不能分离

}

class Mouse {
}

class Moniter {

}

