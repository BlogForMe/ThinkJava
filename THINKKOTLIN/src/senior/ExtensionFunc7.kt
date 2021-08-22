package senior

import java.io.File

//fun String.addExt(amount: Int = 1) = this + " !".repeat(amount)
fun String.addExt() = " !".repeat(this.count())

// 泛型的拓展函数
fun <T> T.easyPrint(): Unit = println(this)


// T.apply 返回的还是T
// T.() -> Unit 传入拓展函数(泛型), 而不是普通的匿名函数 ???
// 拓展函数里自带了接收者对象的this隐式调用
// 匿名函数，也可以是 拓展函数
//普通的匿名函数 ()->Unit
//匿名函数内部this指向一个File对象,隐式调用，File.() -> Unit
public inline fun <T> T.apply(block: T.() -> Unit): T {
    block()
    return this
}

/*public inline fun <File> File.apply(block: File.() -> Unit): File {
    block()
    return this
}*/


fun main() {
    val file = File("xx").apply {
        this.setReadable(true) //默认又一个对象指向File
    }

    //这里分解一下
    //1. 定义拓展函数
    fun File.ext(): Unit {
        setReadable(true)
    }
    //2.给block变量赋值
    val block = File::ext
    //3.传入apply函数
    File("xxx").apply { block }





    doSomething {
        goFix()
    }
    "abcefg".addExt().easyPrint() // "abcefg"调用addExt() ,addExt()有一个对象指向"abcefg"

    "abc".apply {
    }


}

fun doSomething(fix: () -> Unit) {
    fix
}

fun goFix(): Unit {
    "goFxi"
}