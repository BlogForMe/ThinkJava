package senior

//fun String?.printWithDefault(default:String) =print(this ?: default) //null打印默认值,不为null 打印自身
infix fun String?.printWithDefault(default:String) =print(this ?: default) //null打印默认值,不为null 打印自身

fun main() {
//    val nullableString:String? = null
    val nullableString:String? = "hehe"
    nullableString.printWithDefault("abc") // nullableString?就不会设置默认值
    nullableString printWithDefault "abc"
    "girl".to(18)
    mapOf("girl" to 18)
}