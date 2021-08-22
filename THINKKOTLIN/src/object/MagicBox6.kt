package `object`

/*
class MagicBox<T : Human>(vararg item: T) {
    var available = false
    protected var subject: Array<out T> = item //可变参数 必须写out
    fun fetch(index: Int): T? {
        return subject[index].takeIf { available } //当available =true，返回接收者对象
    }

    // return R缩写
    // 业务，把元素进行修改，魔盒里放的是男孩，取出来，变成男人
    //传入subjectModfunction是匿名函数类型 (T)->(R), 这个匿名函数传入的是 T 返回的是R,fetch执行返回的是R类型
    fun <R> fetch(index: Int, subjectModFunction: (T) -> R): R? {
        return subjectModFunction(subject[index]).takeIf { available }
    }

    operator fun get(index: Int): T? = subject[index]?.takeIf { available }

}

open class Human(val age: Int)
class Boy(val name: String, age: Int) : Human(age)
class Man(val name: String, age: Int) : Human(age)
class Dog(val weight: Int)

fun main() {
    val box1 = MagicBox(Boy("John", 20), Boy("Jack", 20), Boy("Jon", 20))
    box1.available = true
    box1.fetch(1)?.run {
        println("you find $name")
    }
    val fetch = box1.fetch(2) {
        Man(it.name, it.age.plus(15))
    }
    box1[0] //重写get
}
*/
