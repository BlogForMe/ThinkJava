package navigation.second


interface ITitleBar {
    fun initBar() {
        BarHelper.init(this)
    }

    fun setTitleTextColor(titleTextColor: Int)
    fun setBgBarColor(color: Int)
}

object BarHelper {

    val barBgColor = 888888
    val titleTextColor = 12

    fun init(bar: ITitleBar) {
        bar.setBgBarColor(barBgColor)
        bar.setTitleTextColor(titleTextColor)
    }
}