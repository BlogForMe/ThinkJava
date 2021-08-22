package medium

import kotlin.math.absoluteValue

class Student(
        _name: String,
        _age: Int,
        _isNormal: Boolean
) {
    var name = _name //临时变量用 _表示 只用一次
        get() = field.capitalize()
        private set(value) {
            value.trim()
        }
    var age = _age //临时变量用 _表示 只用一次
        get() = age.absoluteValue
        set(value) {
            field = value.absoluteValue
        }
    var isNormal = _isNormal
}

fun main() {
    val p = Student("john", 19, true)
//    p.name = "rose" //Cannot assign to 'name': the setter is private in 'Student'
}