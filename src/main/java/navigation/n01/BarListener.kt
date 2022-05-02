/**
 *
 * ClassName:      BarListener
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/11/1 10:28 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/11/1 10:28 PM
 * UpdateRemark:   Modify the description
 */

package navigation.n01


interface BarListener {
    fun init() {
        BarHelper.init(this)
    }

    fun setTitleTextColor(titleTextColor: Int)

    fun setBgBarColor(color:Int)

}


object BarHelper {

    val barBgColor =1
    val titleTextColor =2

    fun init(bar: BarListener){
        bar.setBgBarColor(barBgColor)
        bar.setTitleTextColor(titleTextColor)
    }

    fun init(bar: BarListener1){
        bar.setBgBarColor(barBgColor)
        bar.setTitleTextColor(titleTextColor)
    }
}

class TitleBar : BarListener {
    override fun init() {
        super.init()
    }

    override fun setTitleTextColor(titleTextColor: Int) {
        println("setTitleTextColor $titleTextColor")
    }

    override fun setBgBarColor(color: Int) {
        println("setBgBarColor $color")
    }
}

fun main(){
//    TitleBar().init()
    CommonTitleView().init()
}

