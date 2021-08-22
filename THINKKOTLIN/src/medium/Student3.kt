package medium


class Student3(
        _name: String,
        val age: Int = 20,
        val isNormal: Boolean
) {
    var name = _name //临时变量用 _表示 只用一次
        get() = field.capitalize()
        private set(value) {
            value.trim()
        }

    init{
        require(age>0){"age must be positive"}
        require(name.isNotBlank()){"player must have a name."}
    }

}

fun main() {
    Student3(isNormal = false, _name = "Jon")
    Student3(isNormal = false, _name = "")
}