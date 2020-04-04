package thinkjava.JavaIo.Exercise;

import thinkjava.net.mindview.util.Print;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/1/4.
 */
public class Exercise_03 {
    public static void main(String[] args) {
//        args = new String[]{".git"};
        String p = "D:\\File\\JavaProject\\ThinkInJava\\src\\thinkjava.JavaIo\\Exercise";
        File path = new File(p);
        String[] list = null;
        if (args.length == 0)
            list = path.list();
        else
            list = path.list(new DirFilter(args[0]));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        long sum = 0;
        long fs;
        for (String dirItem : list) {
            fs = new File(path, dirItem).length();
            Print.print(dirItem + "  : " + fs + "  byte(s) ");
            sum += fs;
        }
        Print.print("=======================");
        Print.print(sum + " file(s)." + sum + " bytes");
    }
}


class DirFilter implements FilenameFilter {
    private Pattern pattern;

    public DirFilter(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}