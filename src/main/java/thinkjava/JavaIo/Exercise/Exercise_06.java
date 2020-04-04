package thinkjava.JavaIo.Exercise;

import thinkjava.JavaIo.Demo.BasicIO_01.ProcessFiles;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by jon on 17-1-5.
 */
public class Exercise_06 {
    public static void main(String[] args) {
        String[] arg = new String[]{"D:\\File\\JavaProject\\ThinkInJava\\src\\thinkjava.JavaIo\\Demo", "2016"};

        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.CHINA);
        if (arg.length != 2) {
            System.err.println("Usage : java E06_ProcessFiles3 path date");
            return;
        }
        long tmp = 0;
        try {
            df.setLenient(false);
            tmp = df.parse(arg[1]).getTime();
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        final long modTime = tmp;
        new ProcessFiles(new ProcessFiles.Strategy() {
            @Override
            public void process(File file) {
                if (modTime < file.lastModified())
                    System.out.println(file);
            }
        }, "java").start(new String[]{arg[0]});

    }
}
