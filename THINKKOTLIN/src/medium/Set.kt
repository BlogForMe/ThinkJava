package medium

import java.io.File

fun main() {
    val set = setOf("girl1", "girl2", "girl3", "girl1")
    println(set.elementAt(2))

    val mutableSet = mutableSetOf("girl1", "girl2", "girl3", "girl1")
    mutableSet += "girl5"

    val list = mutableSetOf("girl1", "girl2", "girl3", "girl1").toSet().toList()
    println(list)

    val distinct = mutableSetOf("girl1", "girl2", "girl3", "girl1").distinct()
    println(distinct)

    val intArray = intArrayOf(10, 30, 40)
    listOf(10, 30, 40).toIntArray()
    val array = arrayOf(File("xxx"), File("yyyy"))
}