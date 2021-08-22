package medium

class Student4(
        _name: String,
        val age: Int	 //age 主构造函数里声明的属性
){
    var name = _name	//类级别的属性赋值 	name , score, hobby
    var score = 10;
    private val hobby = "music"
    val subject:String

    init {
        println("initializing student")
        subject = "english"			//Init初始化块里的属性赋值和函数调用
    }
    constructor(_name: String):this(_name,10){
        score = 20		//次构造函数里的属性赋值和函数调用
    }
}

fun main(){
    Student4("jon")
}