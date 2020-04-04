package thinkjava.JavaIo.Demo.BasicIO_01;

import thinkjava.net.mindview.util.PPrint;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/1/4.
 */
public class Directory {
    public static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
//                return pattern.matcher(new File(name).getName()).matches();
                return true;
            }
        });
    }

    public static File[] local(String path, final String regex) { //Overload
        return local(new File(path), regex);
    }

    //A two-tuple for returning a pair of objects;
    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();

        //The default iterable element is the file list;
        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other) {
            files.addAll(other.files);
        }

        @Override
        public String toString() {
            return "dirs: " + PPrint.pformat(dirs) +
                    "\n\nfiles: " + PPrint.pformat(files);
        }
    }

    public static TreeInfo walk(String start, String regex) { //Begin recursion
        return recurseDirs(new File(start), regex);
    }

    public static TreeInfo walk(File start, String regex) { //Overloaded
        return recurseDirs(start, regex);
    }

    public static TreeInfo walk(File start) {
        return recurseDirs(start, ".*");
    }

    public static TreeInfo walk(String start) {
        return recurseDirs(new File(start), ".*");
    }

    private static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles()) {
            if (item.isDirectory()) {
                result.dirs.add(item);
                result.addAll(recurseDirs(item, regex));
            } else //Regular file
                if (item.getName().matches(regex)) {
                    result.files.add(item);
                }
        }
        return result;
    }

    //Simple validation thinkjava.test;
    public static void main(String[] args) {
        String p = "D:\\File\\JavaProject\\ThinkInJava\\src\\thinkjava.JavaIo\\Demo";
        if (args.length == 0) {
            System.out.println(Directory.walk(p));
        } else {
            for (String arg : args)
                System.out.println(Directory.walk(arg));
        }

        /**
         * 或者使用下面这种方式
         */

        for (File file : Directory.local(p, "."))
            System.out.println(file);
    }
}
