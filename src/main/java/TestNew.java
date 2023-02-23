import java.util.ArrayList;
import java.util.List;

public class TestNew {
    public static void main(String[] args) {
//        String needAssitance = "s/faq/faq.html#/detail?id=%s&mark=top10&tngd_source=home_need_assistance";
//        String format = String.format(needAssitance, "82838383");
//        System.out.println(format);

//        int flag1 = 1;
//        int flag2 = 1;
//        String type = "";
//        if (flag1 == flag2 && type != null) {
//            System.out.println("测试");
//        }

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        List<Integer> integers1 = integers.subList(0, 3);
        System.out.println(integers1);
    }
}
