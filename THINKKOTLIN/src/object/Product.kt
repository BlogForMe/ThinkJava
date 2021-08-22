package `object`

import java.io.File

open class Product(val name:String) {
    fun description() = "Product: $name"
   open fun load() = "Nothing.."
}
class LuxuryProduct : Product("Luxury"){
    override fun load() =" LuxuryProduct loading"
    fun special() = "LuxuryProduct special function"
}

fun main() {
    val p : Product = LuxuryProduct()
    println(p.load())

    println(p is Product)
    println(p is LuxuryProduct)
    println(p is File)

    if (p is LuxuryProduct){
        println((p as LuxuryProduct).special())
        println(p.special()) //只要转换一次，后面就直接可以使用，不用转换
    }

    println(p is Any)
    println(p.toString())
}