package thinkjava.JavaIo.Exercise;

import thinkjava.JavaIo.Utils.Constants;
import thinkjava.net.mindview.util.Print;

import java.io.*;

/**
 * Created by jon on 17-1-8.
 */
public class E27_Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        PrintStudent s = new PrintStudent("Jon");
        ObjectOutputStream sOut = new ObjectOutputStream(new FileOutputStream(Constants.writePathU + "Serializable .java"));
        sOut.writeObject(s);
        sOut.close();

        ObjectInputStream sIn = new ObjectInputStream(new FileInputStream(Constants.writePathU + "Serializable .java"));
        PrintStudent stu = (PrintStudent) sIn.readObject();
        Print.print(stu);


        s = new PrintStudent("hehe");
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject(s);
        out2.flush();

        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        s = (PrintStudent) in2.readObject();
        Print.print(s);
    }
}


class PrintStudent implements Serializable {
    private Student student;

    public PrintStudent(String name) {
        this.student = new Student(name);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("StudentName :(");
        result.append(student).append(")");
        return result.toString();
    }
}

class Student implements Serializable {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "My name is :" + name;
    }
}