package pattern.factory.absfactory.pizzastore.order

import pattern.factory.absfactory.pizzastore.pizza.BJCheesePizza
import pattern.factory.absfactory.pizzastore.pizza.BJPepperPizza
import pattern.factory.absfactory.pizzastore.pizza.Pizza

class BJFactory : AbsFactory {
    override fun createPizza(orderType: String): Pizza? {
        println("~使用的抽象工厂模式~")
        var pizza: Pizza? =null
        if (orderType=="cheese"){
            pizza = BJCheesePizza()
        }else if (orderType=="pepper"){
            pizza = BJPepperPizza()
        }
        return pizza
    }
}