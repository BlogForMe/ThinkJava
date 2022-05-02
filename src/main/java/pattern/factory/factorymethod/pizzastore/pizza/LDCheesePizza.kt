package pattern.factory.factorymethod.pizzastore.pizza

class LDCheesePizza : Pizza() {
    override fun prepare() {
        setName("伦敦的奶酪pizza ")
        println("给伦敦的奶酪pizza 准备原材料")
    }
}