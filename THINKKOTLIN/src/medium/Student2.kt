package medium


class Student2(
        _name: String,
        val age: Int,
        val isNormal: Boolean
) {
    var name = _name //临时变量用 _表示 只用一次
        get() = field.capitalize()
        private set(value) {
            value.trim()
        }

    constructor(_name:String):this(_name,age=100,isNormal = false)
    constructor(_name:String,age: Int):this(_name,age=100,isNormal = false){ //定义初始化代码逻辑
        this.name = name.uppercase()
    }

}

fun main() {
    val p = Student2("john", 19, true)
//    p.name = "rose" //Cannot assign to 'name': the setter is private in 'Student'
    val p2 = Student2("Rose")
    val p3 = Student2("Rose",20)
}