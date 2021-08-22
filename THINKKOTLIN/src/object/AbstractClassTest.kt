package `object`

abstract class Gun(val range: Int) {
    abstract fun pullTrigger(): String
    protected fun doSomething() {
        println("doSomething")
    }
}

class AK47(val price: Int) : Gun(range = 500){
    override fun pullTrigger(): String {
        TODO()
    }
}