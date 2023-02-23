package generics.work;

import com.tngd.uikitsdk.view.bar.generics.work.MPBannerHelperCallBack;
import com.tngd.uikitsdk.view.bar.generics.work.MpObjectBanner;
import generics.extendsuper.Fruit;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TestGenerics {
    public static void main(String[] args) {
        MpObjectBanner.INSTANCE.refrash(new MPBannerHelperCallBack() {

            @Override
            public void refreshMPBannerView(@NotNull List<? extends Fruit> launchableItem) {
            }

            @Override
            public void funFirst() {
            }

        });


        MpObjectBannerJava.INTANCE.refresh(new MpObjectBannerJava.MPBannerHelperCallBackJava() {
            @Override
            public void funFirst() {

            }

            @Override
            public void refreshMPBannerViewJava(List<Fruit> launchableItem) {

            }
        });
    }

}
