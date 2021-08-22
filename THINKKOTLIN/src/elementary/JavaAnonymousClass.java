package elementary;

import java.util.Random;

public class JavaAnonymousClass {
    public static void main(String[] args) {
        showOnBoard("牙膏",((goodsName, hour) -> {
            int currentYear = 2023;

            return String.format("%s年，双11 %s 促销倒计时 %d小时 ",currentYear,goodsName,hour);
        }));
    }
    public interface DiscountWords{
        String getDiscountWords(String goodsName,int hour);
    }

    public static void showOnBoard(String goodsName,DiscountWords discountWords){
        int hour  = new Random().nextInt(24);
        System.out.println(discountWords.getDiscountWords(goodsName,hour));
    }
}
