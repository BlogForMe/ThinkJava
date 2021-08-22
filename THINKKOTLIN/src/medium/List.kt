package medium

fun main() {
    val list = listOf("girl1", "girl2", "girl3")
    println(list.getOrElse(3) { "Unknown" })
    println(list.getOrNull(3))
    println(list.getOrNull(3) ?: "Unknown")

    val mutableList = mutableListOf("Jason", "Jack", "girl1")
    mutableList.add("Jimmy")
    mutableList.remove("Jack")
    println(mutableList)

    list.toMutableList() // 不可变转可变
    mutableList.toList() // 可变转不可变

    mutableList += "John"
    mutableList -= "girl1"
    mutableList.removeIf{it.contains("Jack")} //包含Jack就把 Jack移除
    println(mutableList)


    for (s in list){
        println(s)
    }
    list.forEach{
        println(it)
    }
    list.forEachIndexed{index,item->
        println("$index  $item")
    }

//    val(girl1,girl2,girl3) = list
    val(girl1,_,girl3) = list   //如果不需要girl2,用_，这个字节码也不会取出


}