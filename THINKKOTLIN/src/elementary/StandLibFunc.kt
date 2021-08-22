import java.io.File

fun main() {

    // 配置一个File实例
    val file = File("E// I have a dream.txt")
    file.setReadable(true)
    file.setWritable(true)
    file.setExecutable(false)

    //使用apply
    val file1 = File("E// I have a dream.txt").apply {
        setReadable(true)
        setWritable(true)
        setExecutable(false)
    }

    var result = listOf(3, 2, 1).first().let { it * it }

//    val firstElement = listOf(3, 2, 1).first()
//    val result = firstElement * firstElement

    println(formatGreeting(null))
    println(formatGreeting("Jack"))
}

fun formatGreeting(guestNmae: String?): String {
    return guestNmae?.let {
        "Welcom, $it"
    } ?: "What's your name"
}

fun formatGreeting2(guestNmae: String?): String {
    return if (guestNmae != null) {
        "Welcom, $guestNmae"
    } else {
        "What's your name"
    }
}


