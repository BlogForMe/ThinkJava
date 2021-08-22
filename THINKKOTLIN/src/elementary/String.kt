import javax.print.attribute.standard.MediaSize

const val NAME ="Jimmy's friend"
const val NAMES = "Lucy1 , Lucy2 , Lucy3, Lucy4"
fun main() {
    val index = NAME.indexOf('\'') // \转义 '
    NAME.substring(0,index) // java写法
    val str = NAME.substring(0 until index)
    println(str)

    val data = NAMES.split(",")
    val (girl1,girl2,girl3,girl4) = NAMES.split(",")
    println("$girl1  $girl2  $girl3  $girl4 ")

    /**
     * 加密替换一个字符串
     */
    val str1  = "The people's Republic of China."
    //第一个参数是正则表达式，用来决定要替换哪些字符
    //第二个参数是匿名函数，用来确定如何替换正则表达式搜索到的字符
    val str2 = str1.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "8"
            "e" -> "6"
            "i" -> "9"
            "o" -> "1"
            "u" -> "3"
            else -> it.value
        }
    }
    println(str1)
    println(str2)



    val str3 = "Jason"
    val str4 = "Jason"
    println(str3==str4)
    println(str3===str4) //相同字符串的字符串，使用字符串常量池中相同的对象

    val str5 = "jason".capitalize() //这种情况会创建新的对象，why?
    println(str3===str5)


    str1.forEach {
        print("$it ")
    }

}