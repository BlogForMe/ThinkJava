package `object`

import java.io.File

/**
 * 只要调用load() 或者实例化ConfigMap, 这个companion object才会被实例化
 * 而且也是单例的
 */
class ConfigMap {
    companion object{
        private const val PATH = "xxxx"
        fun load() = File(PATH).readBytes()
    }
}

fun main() {
    //  类似于Java static
    ConfigMap.load()
}