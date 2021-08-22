package medium

class InitTrapTest1 {
    val blood  = 100
    init {
        val bloodBonus = blood.times(4)  //必须保证块中的所有属性已完成初始化
    }
}