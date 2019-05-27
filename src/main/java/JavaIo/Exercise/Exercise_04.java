package JavaIo.Exercise;


import JavaIo.Demo.BasicIO_01.Directory;

import java.io.File;

/**
 * Created by Administrator on 2017/1/4.
 */
public class Exercise_04 {
    public static void main(String[] args) {
        String p = "D:\\File\\JavaProject\\ThinkInJava\\src\\JavaIo\\Demo";
        if (args.length == 0) {
            System.out.println(Directory.walk(p));
        } else {
            for (String arg : args)
                System.out.println(Directory.walk(arg));
        }

        /**
         * 或者使用下面这种方式
         */
        long total = 0;
        for (File file : Directory.local(p, ".")) {
            total += file.length();
        }
        System.out.println("file(s), " + total + "byte(s)");
    }
}
