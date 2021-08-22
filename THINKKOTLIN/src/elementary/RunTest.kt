import java.io.File

const val FILE_DREAM = "THINKKOTLIN/I have a dream.txt"

fun main() {
    var file = File(FILE_DREAM)
    val result = file.run {
        readText().contains("great") //最后一行执行结果返回
        "xxx"
    }
    println(result)

    val result2 = "The people's Republic of china.".run(::isLong)
    println(result2)

    "The people's Republic of china."
            .run(::isLong)
            .run(::showMessage)
            .run(::println)


    var result3 = "The people's Republic of china.".run { length > 10 }
    val result4 = with("The people's Republic of china.") { length >= 10 }

    var fileContents: List<String>
    File(FILE_DREAM)
            .also {
                println(it.name)
            }.also {
                fileContents = it.readLines()
            }
    println(fileContents)


    //takeif
    //如果 it.exists() && it.canRead() 返回true,返回file对象，接着执行后面语句。
    // 如果为false，就返回null,就不会执行后面的语句。
    val readText = File(FILE_DREAM)
            .takeIf { it.exists() && it.canRead() }
            ?.readText()
    println(readText)

    val result5 = File(FILE_DREAM)
            .takeUnless { it.isHidden }
            ?.readText()
    println(result5)


}

fun isLong(name: String) = name.length > 10

fun showMessage(isLong: Boolean): String {
    return if (isLong) {
        "Name is too long."
    } else {
        "Please rename."
    }
}
