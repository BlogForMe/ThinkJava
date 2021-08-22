package `object`

open class Player {
    open fun load() = "loading nothing.."
}

fun main() {
    //匿名内部类，实例p对象
    val p = object : Player(){
        override fun load()= "anonymous nothing.."
    }
    println(p.load())
}