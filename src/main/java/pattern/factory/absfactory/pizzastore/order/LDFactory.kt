package pattern.factory.absfactory.pizzastore.order

import pattern.factory.absfactory.pizzastore.pizza.*

class LDFactory : AbsFactory {
    override fun createPizza(orderType: String): Pizza? {
        println("~使用的抽象工厂模式~")
        var pizza: Pizza? =null
        if (orderType=="cheese"){
            pizza = LDCheesePizza()
        }else if (orderType=="pepper"){
            pizza = LDPepperPizza()
        }
        return pizza
    }
}