package navigation.second;

public class CommonTitleView2 implements  ITitleBar{
    @Override
    public void setTitleTextColor(int titleTextColor) {
        System.out.println("titleTextColor " +titleTextColor);
    }

    @Override
    public void setBgBarColor(int color) {
        System.out.println("color " +color);
    }

    @Override
    public void initBar() {
//        ITitleBar.super.initBar();
    }
}
