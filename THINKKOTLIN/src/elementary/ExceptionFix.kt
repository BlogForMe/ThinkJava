package elementary

import java.lang.Exception

fun main() {
    var number: Int? = null

    try {
        checkOperation(number)
        number!!.plus(1)
    } catch (e: Exception) {
        println(e)
    }
}
fun checkOperation(number: Int?) {
//    number ?: throw  UnskilledException()
    checkNotNull(number,{"Something is no good."})
}
//自定义异常
class UnskilledException : IllegalArgumentException("操作不当")
