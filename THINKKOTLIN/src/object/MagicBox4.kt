package `object`

/*
class MagicBox<T:Human>(item: T) {
    var available = false
    protected var subject: T = item
    fun fetch(): T? {
        return subject.takeIf { available } //当available =true，返回接收者对象
    }

    // return R缩写
    // 业务，把元素进行修改，魔盒里放的是男孩，取出来，变成男人
    //传入subjectModfunction是匿名函数类型 (T)->(R), 这个匿名函数传入的是 T 返回的是R,fetch执行返回的是R类型
    fun <R> fetch(subjectModFunction: (T) -> R): R? {
        return subjectModFunction(subject).takeIf { available }
    }
}

open class Human(val age: Int)
class Boy(val name: String, age: Int) : Human(age)
class Man(val name: String,  age: Int):Human(age)
class Dog(val weight: Int)

fun main() {
    val box1 = MagicBox(Boy("John", 20))
//    val box2 = MagicBox(Dog(20))
    box1.available = true
    box1.fetch()?.run {
        println("you find $name")
    }

    val fetch = box1.fetch {
        Man(it.name, it.age.plus(15))
    }
}
*/
