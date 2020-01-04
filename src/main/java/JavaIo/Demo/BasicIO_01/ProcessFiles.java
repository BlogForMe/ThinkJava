package JavaIo.Demo.BasicIO_01;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/1/4.
 * 策略设计模式
 */
public class ProcessFiles {
    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;
    private String ext;

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args) {
        try {
            if (args.length == 0)
                processDirectoryTree(new File("."));
            else
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory())
                        processDirectoryTree(fileArg);
                    else
                        //Allow user to leave off extension:
                        if (!arg.endsWith("." + ext))
                            new File(arg).getCanonicalFile();
//                    if (arg.matches(ext))
//                          new File(arg).getCanonicalFile();

                }
        } catch (IOException e) {

        }

    }

    /**
     * getCanonicalFile（）: 这个方法是返回文件方法的绝对路径
     *
     * @param root
     * @throws IOException
     */
    private void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsoluteFile(), ".*\\." + ext))
            strategy.process(file.getCanonicalFile());
    }

    public static void main(String[] args) {
        String[] p = new String[]{"D:\\File\\JavaProject\\ThinkInJava\\src\\JavaIo\\Demo"};

        new ProcessFiles(new Strategy() {

            @Override
            public void process(File file) {
                System.out.println(file);
            }
        }, "java").start(p);
    }
}
