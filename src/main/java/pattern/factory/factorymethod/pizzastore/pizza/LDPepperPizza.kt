package pattern.factory.factorymethod.pizzastore.pizza

class LDPepperPizza : Pizza() {
    override fun prepare() {
        setName("伦敦的胡椒pizza ")
        println("给伦敦的胡椒pizza 准备原材料")
    }
}