package pattern.principle.improve;

import java.util.ArrayList;
import java.util.List;

public class Demeter2 {
    public static void main(String[] args) {
        System.out.println("使用迪米特法则的改进");
        SchoolManager schoolManager = new SchoolManager();
        schoolManager.printAllEmployee(new CollegeManger());

    }
}


//学校总部员工的类
class SchollEmployee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

//学院的员工
class CollegeEmployee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

//管理学院员工的管理类
class CollegeManger {
    public List<CollegeEmployee> getAllEmployee() {
        ArrayList<CollegeEmployee> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CollegeEmployee collegeEmployee = new CollegeEmployee();
            collegeEmployee.setId("学院员工id= " + i);
            list.add(collegeEmployee);
        }
        return list;
    }

    // 输出学院员工的信息
    void printCollegeEmployee() {
        //改进方法： 将输出学院员工的方法，封装到CollegeManager中。
        List<CollegeEmployee> list1 = getAllEmployee();
        System.out.println("-----------学院员工--------");
        for (CollegeEmployee e : list1) {
            System.out.println(e.getId());
        }
    }
}


// SchollEmployee , CollegeManger 是直接朋友
// CollegeEmployee 不是直接朋友，而是一个陌生类，这样违反了 迪米特法则。
class SchoolManager {

    public List<SchollEmployee> getAllEmployee() {//方法返回值:直接朋友
        ArrayList<SchollEmployee> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SchollEmployee schollEmployee = new SchollEmployee(); // CollegeEmployee 不是直接朋友，以局部变量出现在SchoolManager
            schollEmployee.setId("学校总部员工id= " + i);
            list.add(schollEmployee);
        }
        return list;
    }

    //该方法完成输出学校总部和学院员工ID
    void printAllEmployee(CollegeManger sub) {//方法参数:直接朋友

      /*
        List<CollegeEmployee> list1 = sub.getAllEmployee();
        System.out.println("-----------学院员工--------");
        for (CollegeEmployee e : list1) {
            System.out.println(e.getId());
        }*/
        //改进方法： 将输出学院员工的方法，封装到CollegeManager中。
        sub.printCollegeEmployee();

        List<SchollEmployee> list2 = this.getAllEmployee();
        System.out.println("-----------学校总部员工--------");
        for (SchollEmployee e : list2) {
            System.out.println(e.getId());
        }
    }
}