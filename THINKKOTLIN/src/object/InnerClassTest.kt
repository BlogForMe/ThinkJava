package `object`


class InnerClassTest {
    class Equipment(var name:String){
        fun show() = println("equipment:$name")
    }
    fun battle(){

    }
}

fun main() {
    InnerClassTest.Equipment("shap knife").show()
}
