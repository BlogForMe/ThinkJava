package senior

fun main() {
    val animals = listOf("zebra", "giraffe", "elephant", "rat")
    val banies = animals.map { animal ->
        "A baby $animal"
    }.map {
        baby -> "$baby , with the cutest little tail ever!"
    }

    println(animals)
    println(banies)

    val animalsLength = animals.map { it.length }
    println(animalsLength)
}