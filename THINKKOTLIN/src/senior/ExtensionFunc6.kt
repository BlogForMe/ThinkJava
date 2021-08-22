package senior

import com.util.kotin.extension.randomTake as Randomizer


fun main() {
    var list = listOf("Jack", "Json", "John")
    var set = listOf("Jack", "Json", "John")
    list.shuffled().first()

//    list.randomTake()
    list.Randomizer()
}