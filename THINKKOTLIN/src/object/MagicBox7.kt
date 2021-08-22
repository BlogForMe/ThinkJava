package `object`

class MagicBox<T : Human>() {
    //随机产生一个对象，如果不是指定类型的对象，就通过backup函数生成一个指定类型的对象
    /*  fun <T> randomOrBackup(backup: () -> T): T {    // backup: ()->T 函数 和randomOrBackup返回的都是T类型
          val items = listOf(Boy("jocnk", 20), Man("john", 20))
          val random = items.shuffled().first()
          return if (random is T) {
              random
          } else {
              backup()
          }
      } */

    // backup: ()->T 函数 和randomOrBackup返回的都是T类型
    //inline  reified一起使用
    inline fun <reified T> randomOrBackup(backup: () -> T): T {
        val items = listOf(Boy("jocnk", 20), Man("john", 20))
        val random = items.shuffled().first()
        println(random)
        return if (random is T) {
            random
        } else {
            backup()
        }
    }
}

open class Human(val age: Int)
class Boy(val name: String, age: Int) : Human(age){
    override fun toString(): String {
        return "Boy(name='$name')"
    }
}
class Man(val name: String, age: Int) : Human(age){
    override fun toString(): String {
        return "Man(name='$name')"
    }
}

fun main() {
    val box1: MagicBox<Man> = MagicBox()
    // 由backup函数推断出来T的类型
    val subject = box1.randomOrBackup { Man("Jimmy", 28) } //Man推断T类型
    println(subject)
}
