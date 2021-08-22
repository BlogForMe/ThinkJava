package `object`

data  class Student(
        var name: String,
        val age: Int	 //age 主构造函数里声明的属性
){
    private val hobby = "music"
    val subject:String
    var score = 0

    init {
        println("initializing student")
        subject = "english"			//Init初始化块里的属性赋值和函数调用
    }
    constructor(_name: String):this(_name,10){
        score = 10; //次构造函数数据不会copy过来
    }

    override fun toString(): String {
        return "Student(name='$name', age=$age, hobby='$hobby', subject='$subject', score=$score)"
    }
}

fun main() {
    val s = Student("Jon")
    val copy = s.copy("girl")
    var s2 = s.copy(name = "girl2", age = 18)
    println(s)
    println(s2)
    println(copy)
}