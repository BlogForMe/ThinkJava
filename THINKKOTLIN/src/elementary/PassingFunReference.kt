//函数引用
fun main() {
    showOnBoard("小玩具",::getDiscountWords)
}

//普通 具名函数
private fun getDiscountWords(goodsName: String, hour: Int): String {
    val currentYear = 2023;
    return "${currentYear}年, 双11 ${goodsName}促销倒计时: $hour 小时"
}

//getDiscountWord是第二个参数,类型时是(String, Int) -> String 函数类型
private fun showOnBoard(goodsName: String, getDiscountWords: (String, Int) -> String) {
    val hour = (1..24).shuffled().last();
    println(getDiscountWords(goodsName, hour))
}