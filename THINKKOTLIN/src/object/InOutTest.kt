package `object`

// out
interface Production<out T> {
    fun product(): T
}

// in
interface Consumer<in T> {
    //    fun consume(item:T):T //Type parameter T is declared as 'in' but occurs in 'out' position in type T
    fun consume(item: T)
}

//不变
interface ProductionConsumer<T> {
    fun product(): T
    fun consume(item: T)
}

open class Food
open class FastFood:Food()
open class Burger :FastFood()

//生产者
class FoodStore : Production<Food>{
    override fun product(): Food {
        println("Product food")
        return Food()
    }
}

class FastFoodStore : Production<FastFood>{
    override fun product(): FastFood {
        println("Product FastFood")
        return FastFood()
    }
}

class BurgerFoodStore : Production<Burger>{
    override fun product(): Burger {
        println("Product Burger")
        return Burger()
    }
}

//消费者
class EveryBody : Consumer<Food>{
    override fun consume(item: Food) {
        println("Eat food.")
    }
}
class ModernPeople : Consumer<FastFood>{
    override fun consume(item: FastFood) {
        println("Eat fastFood")
    }
}
class AmericanPeople : Consumer<Burger>{
    override fun consume(item: Burger) {
        println("Eat Burger")
    }
}


fun main() {
    val production1 : Production<Food> = FoodStore() // 理解时，别看方法只看类就可以了，父子类关系

    //子类泛型对象可以复制给负累泛型对象，用out
    val production2 : Production<Food> = FastFoodStore() // 就是因为有 out，out删除就报错


    //父类泛型对象可以赋值给子类泛型对象 ， 用in
    val consumer1:Consumer<Burger> = EveryBody()
//    val consumer2:Consumer<Food> = ModernPeople()//Required:Consumer<Food> Found : ModernPeople
    val consumer2:Consumer<Burger> = ModernPeople()
    consumer2.consume(Burger())
//    consumer2.consume(Food())
    val consumer3:Consumer<Burger> = AmericanPeople()
}
