package `object`

object ApplicationConfig {
    init {
        println("ApplicationConfig loading...")
    }
    fun doSomething(){
        println("doSomething")
    }
}

fun main(){
    //ApplicationConfig 即是 类名 又是实例名
    ApplicationConfig.doSomething()
    println(ApplicationConfig)
    println(ApplicationConfig)
}