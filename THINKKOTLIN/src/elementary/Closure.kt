fun main() {
    val getDiscountWords = configDiscountWords()
    println(getDiscountWords("小玩具"))
}

fun configDiscountWords(): (String) -> String { //返回一个传入字符串 返回类型也是函数的字符串。
    val currentYear = 2023;
    val hour = (1..24).shuffled().last();
    return { goodsName: String ->
        "${currentYear}年, 双11 ${goodsName}促销倒计时: $hour 小时"
    }
}
