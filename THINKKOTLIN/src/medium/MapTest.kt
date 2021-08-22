package medium

fun main() {
    val map = mapOf("lucy1" to 18, "lucy2" to 19, "lucy3" to 20) //to调用to方法生成Pair
    mapOf(Pair("lucy1",18),Pair("lucy2",19),Pair("lucy3",20)) //上面实现原理


    println(map["lucy1"])
    println(map.getValue("lucy2"))
    println(map.getOrElse("Jon"){"Unknown"}) //没有Jon，返回Unknown
    println(map.getOrDefault("Jon",0)) //没有Jon，返回默认值0

    map.forEach{
        println("${it.key}, ${it.value}")
    }
    map.forEach{(key:String,value:Int)->
        println("${key}, ${value}")
    }


    val mutableMap = mutableMapOf("lucy1" to 18, "lucy2" to 19, "lucy3" to 20)
    mutableMap += "jon" to 22
    mutableMap.put("jon2",35)
    mutableMap.getOrPut("Rose"){30} // 如果没有Rose,就添加进来
    println(mutableMap)

}