package reflection.liao;

public class Main01 {
    public static void main(String[] args) {
        Class stdClass = Student.class;
        // 获取public方法getScore，参数为String:
        try {
            System.out.println(stdClass.getMethod("getScore", String.class));
            // 获取继承的public方法getName，无参数:
            System.out.println(stdClass.getMethod("getName"));
            // 获取private方法getGrade，参数为int:
            System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}



