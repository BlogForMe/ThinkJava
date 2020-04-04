package thinkjava.JavaIo.Demo.BasicIO_01;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by jon on 17-1-3.
 * 18.1.1  匿名内部类
 */
public class DirList2 {
    public static FilenameFilter filter(final String regex) {
        //Creation of anonymous inner class;
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {

                return pattern.matcher(name).matches();
            }
        };
    }

    public static void main(String[] args) {
        args = new String[]{".git"};

        File path = new File(".");
        String[] list = null;
        if (args.length == 0)
            list = path.list();
        else
            list = path.list(new DirFilter(args[0]));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list)
            System.out.println(dirItem);
    }
}
