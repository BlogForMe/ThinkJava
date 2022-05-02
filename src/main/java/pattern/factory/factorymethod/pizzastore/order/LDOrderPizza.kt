package pattern.factory.factorymethod.pizzastore.order

import pattern.factory.factorymethod.pizzastore.pizza.LDCheesePizza
import pattern.factory.factorymethod.pizzastore.pizza.LDPepperPizza
import pattern.factory.factorymethod.pizzastore.pizza.Pizza


class LDOrderPizza : OrderPizza() {


    override fun createPizza(orderType: String?): Pizza? {
        var pizza: Pizza?=null
        if (orderType == "cheese") {
            pizza = LDCheesePizza()
        }else if (orderType=="pepper"){
            pizza = LDPepperPizza()
        }
        return pizza;
    }
}