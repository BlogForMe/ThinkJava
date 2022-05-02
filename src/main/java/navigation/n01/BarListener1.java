package navigation.n01;

public interface BarListener1 {
    default void init() {
        BarHelper.INSTANCE.init(this);
    }

    void setTitleTextColor(int titleTextColor);

    void setBgBarColor(int color);
}
