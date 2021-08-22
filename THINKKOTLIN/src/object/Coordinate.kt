package `object`

data class Coordinate(var x:Int,var y:Int) {
    val isInBounds = x > 0 && y > 0
}

fun main() {
    println(Coordinate(10,20))
    println(Coordinate(10,20)==Coordinate(10,20)) //data默认重写equls方法

    val(x,y) = Coordinate(10,20)
    println("$x , $y")
}