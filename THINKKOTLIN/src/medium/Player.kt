package medium

class Player {
    var name: String = "jack"
        get() = field.capitalize()
        set(value) {
            field = value.trim()
        }

    //计算属性是通过一个覆盖的get或set运算符来定义，这时field就不需要了。
    val rolledValue
        get() = (1..6).shuffled().first()

//    如果一个类属性即可空又可变，那么引用它之前必须保证它非空，一个办法是用also标准函数
    var words:String? = "hello"
    fun saySomething(){
        words?.also {
            println("Hello ${it.uppercase()}")
        }
    }
}
fun  main(){
    val p = Player()
    println(p.name)
    p.name = "  rose    "
    println(p.name)
}