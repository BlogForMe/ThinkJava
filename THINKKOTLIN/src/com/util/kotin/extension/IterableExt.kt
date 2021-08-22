package com.util.kotin.extension

fun <T> Iterable<T>.randomTake(): T = this.shuffled().first()