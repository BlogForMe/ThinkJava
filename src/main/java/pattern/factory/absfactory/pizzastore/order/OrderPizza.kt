package pattern.factory.absfactory.pizzastore.order

import pattern.factory.absfactory.pizzastore.pizza.Pizza
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class OrderPizza(absFactory: AbsFactory?){

    init {
        setFactory(absFactory)
    }

    fun setFactory(factory: AbsFactory?){
        var pizza:Pizza?
        var orderType = ""//用户输入

        do {
            orderType = getType()
            //factory 可能是北京的工厂子类，也可能是伦敦的工厂子类
            pizza = factory?.createPizza(orderType)
            if (pizza!=null){ //订购ok
                pizza.prepare()
                pizza.bake()
                pizza.cut()
                pizza.box()
            }else{
                println("订购失败")
                break
            }
        }while (true)

    }


    // 写一个方法，可以获取客户希望订购的披萨种类
    private fun getType(): String {
        return try {
            val strin = BufferedReader(InputStreamReader(System.`in`))
            println("input pizza 种类:")
            strin.readLine()
        } catch (e: IOException) {
            e.printStackTrace()
            ""
        }
    }
}