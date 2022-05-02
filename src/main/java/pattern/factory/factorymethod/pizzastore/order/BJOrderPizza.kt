package pattern.factory.factorymethod.pizzastore.order

import pattern.factory.factorymethod.pizzastore.pizza.BJCheesePizza
import pattern.factory.factorymethod.pizzastore.pizza.BJPepperPizza
import pattern.factory.factorymethod.pizzastore.pizza.Pizza


class BJOrderPizza : OrderPizza() {


    override fun createPizza(orderType: String?): Pizza? {
        var pizza: Pizza?=null
        if (orderType == "cheese") {
            pizza = BJCheesePizza()
        }else if (orderType=="pepper"){
            pizza = BJPepperPizza()
        }
        return pizza;
    }
}