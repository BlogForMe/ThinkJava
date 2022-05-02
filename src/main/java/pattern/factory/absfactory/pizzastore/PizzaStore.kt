package pattern.factory.absfactory.pizzastore

import pattern.factory.absfactory.pizzastore.order.BJFactory
import pattern.factory.absfactory.pizzastore.order.OrderPizza

fun main() {
    OrderPizza(BJFactory())
}