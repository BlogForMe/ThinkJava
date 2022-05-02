package pattern.factory.absfactory.pizzastore.order

import pattern.factory.absfactory.pizzastore.pizza.Pizza

//一个抽象工厂模式的抽象层（接口）
interface AbsFactory {
    //让下面的工厂子类来 具体实现
    fun  createPizza(orderType:String):Pizza?
}