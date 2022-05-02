package reflection.liao;

class Student extends Person {
    public int getScore(String type) {
        return 99;
    }



    private int getGrade() {
        return 100;
    }
    private int setGrade(int year) {
        return 1;
    }

//    @Override
//    public void hello() {
//        System.out.println("Student:hello");
//    }
}

class Person {
    public String getName() {
        return "A Person";
    }

    public void hello() {
        System.out.println("Person:hello");
    }
}