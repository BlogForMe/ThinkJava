package medium

class InitTrapTest3(_name:String) {
    val playerName:String = initPlayerName()
    val name:String = _name     //这个要放第一句
    private fun initPlayerName() = name

}
fun main() {
   println(InitTrapTest3("John").playerName)
}