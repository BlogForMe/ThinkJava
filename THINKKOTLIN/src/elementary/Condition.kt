import sun.management.Agent

fun main() {
    val score = 6;
    if (score in 9..10) {
        println("Big美女")
    } else if (score in 6..8) {
        println("美女")
    } else {
        println("who knows")
    }
    if (score !in 1..5) {
        println("good")
    }

    val school = "0小学";
    val level = when (school) {
        "幼儿园" -> "幼儿"
        "小学" -> "少儿"
        "中学" -> "青少年"
        else -> {
            "未知"
        }
    }
    println(level)

    /**
     * String模版
     */
    val flag = false
    println("Answer is : ${if (flag) "我可以" else "I can play"}")

    TODO("nothing")
    printUser("Jon")
    printUser(name = "john")



}

fun printUser(name:String,age:Int=2){
    println(name+age)
}