package `object`

enum class Direction {
    EAST,
    WEST,
    SOUTH,
    NORTH
}

fun main() {
    println(Direction.EAST)
    println(Direction.EAST is Direction)
}