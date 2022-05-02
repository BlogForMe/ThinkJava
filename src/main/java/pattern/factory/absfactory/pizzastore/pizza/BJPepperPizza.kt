package pattern.factory.absfactory.pizzastore.pizza

class BJPepperPizza : Pizza() {
    override fun prepare() {
        setName("北京的胡椒pizza ")
        println("给北京的胡椒pizza 准备原材料")
    }
}