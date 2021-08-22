fun main() {
    //定义参数是函数 的函数
    val disCountWord = ({ goodsName: String, hour: Int ->
        val currentYear = 2023;
        "${currentYear}年, 双11 ${goodsName}促销倒计时: $hour 小时"
    })


    showOnBoard("小玩具", disCountWord)

//    showOnBoard("小玩具", { goodsName: String, hour: Int ->
//        val currentYear = 2023;
//        "${currentYear}年, 双11 ${goodsName}促销倒计时: $hour 小时"
//    })
//
//    showOnBoard("小玩具") { goodsName: String, hour: Int ->
//        val currentYear = 2023;
//        "${currentYear}年, 双11 ${goodsName}促销倒计时: $hour 小时"
//    }
}


//getDiscountWord是第二个参数,类型时是(String, Int) -> String 函数类型
private fun showOnBoard(goodsName: String, getDiscountWords: (String, Int) -> String) {
    val hour = (1..24).shuffled().last();
    println(getDiscountWords(goodsName, hour))
}