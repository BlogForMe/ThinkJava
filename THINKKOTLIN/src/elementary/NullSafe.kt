fun main() {
    var str:String? = "butterfly"
//    var str=""
    str = str?.let {
        if (it.isNotBlank()){
            it.capitalize()
        }else{
            "butterfly"
        }
    }
//    println(str!!.capitalize())

    str=null
    str="guy"
    str = str?.let { it.capitalize()} ?:"butterfly"
    println(str ?: "girl") // str=null,就是girl,不为null就是自己

}