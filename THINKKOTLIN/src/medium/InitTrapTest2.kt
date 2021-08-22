package medium

class Player7 {
   val name:String //类级别属性
   private fun  firstLetter() = name[0]
    init {
        name= "john"    //初始化块代码
        println(firstLetter())
    }
}

fun main() {
    Player7()
}