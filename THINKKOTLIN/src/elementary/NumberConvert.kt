import kotlin.math.roundToInt

fun main() {
//    val number1 = "6.66".toInt()
    val number1:Int? = "6.66".toIntOrNull()
    println(number1)

    println(8.956765.toInt())
    println(8.956765.roundToInt()) //四舍五入
    val s = "%.2f".format(8.956765)
    println(s)
}