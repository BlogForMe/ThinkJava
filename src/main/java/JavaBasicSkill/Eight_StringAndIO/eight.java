package JavaBasicSkill.Eight_StringAndIO;

import JavaIo.Demo.BasicIO_01.Constants;

import java.io.File;
import java.util.Scanner;

/**
 * Created by jon on 16-4-16.
 * 使用Scanner读数据
 */
public class eight {
    public static void main(String[] args) throws  Exception {
        File file = new File(Constants.javaBasicSkillpath+"eight.java");
        Scanner input = new Scanner(file);
        while (input.hasNext()){
            System.out.println(input.next());
        }
        input.close();

    }
}
