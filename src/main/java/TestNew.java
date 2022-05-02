public class TestNew {
    public static void main(String[] args) {
        String needAssitance = "s/faq/faq.html#/detail?id=%s&mark=top10&tngd_source=home_need_assistance";
        String format = String.format(needAssitance, "82838383");
        System.out.println(format);
    }
}
