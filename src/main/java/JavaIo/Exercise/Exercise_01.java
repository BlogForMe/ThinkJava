package JavaIo.Exercise;


import net.mindview.util.TextFile;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jon on 17-1-3.
 */
public class Exercise_01 {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0)
            list = path.list();
        else
            list = path.list(new FilenameFilter() {
                private String ext = args[0].toLowerCase();

                @Override
                public boolean accept(File dir, String name) {
                    //Only analyze source files with the specified
                    //extension (given as the first command line argument)
                    if (name.toLowerCase().endsWith(ext)) {
                        //Only filter upon file extension?
                        if (args.length == 1)
                            return true;
                        Set<String> words = new HashSet<>(new TextFile(new File(dir, name).getAbsolutePath(), "\\w"));
                        for (int i = 1; i < args.length; i++)
                            if (words.contains(args[i]))
                                return true;
                    }

                    return false;
                }
            });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list)
            System.out.println(dirItem);
//            try {
//                System.out.println(new File(dirItem).getCanonicalFile());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

    }
}
