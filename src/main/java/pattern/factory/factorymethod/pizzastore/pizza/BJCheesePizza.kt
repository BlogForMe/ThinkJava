package pattern.factory.factorymethod.pizzastore.pizza

class BJCheesePizza : Pizza() {
    override fun prepare() {
        setName("北京的奶酪pizza ")
        println("给北京的奶酪pizza 准备原材料")
    }
}