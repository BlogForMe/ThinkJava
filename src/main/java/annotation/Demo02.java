package annotation;

@Annotation01
public class Demo02 {
    @Annotation01(age = 19, studentName = "老高",
            id = 1001, schools = {"哈工大", "清华大学"})
    public void test() {
    }
    @Annotation02(value = "aaaa")
    public void test01() {

    }
    @Annotation02("aaaa")
    public void test02() {
    }
}
