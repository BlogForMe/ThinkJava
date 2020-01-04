package Generics.Demo.Qustion_05;

/**
 * Created by jon on 17-1-15.
 * 15.11.2 实现参数化接口
 */
interface Payable<T> {
}

class Employee implements Payable {
}

class Hourly extends Employee implements Payable {
}


public class MultipleInterfaceVariants {
    public static void main(String[] args) {
        new Employee();
        new Hourly();
    }
}
