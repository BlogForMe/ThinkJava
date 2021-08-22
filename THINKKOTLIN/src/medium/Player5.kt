package medium

class Player5(_name: String) {
    var name = _name

    val config by lazy { loadConfig() } // 懒汉式
//    val config = loadConfig()   //饿汉式

    private fun loadConfig(): String {
        println("loading...")
        return "beauty girl"
    }
}

fun main() {
    val p = Player5("girl")
    Thread.sleep(5000)
    println(p.config)
}