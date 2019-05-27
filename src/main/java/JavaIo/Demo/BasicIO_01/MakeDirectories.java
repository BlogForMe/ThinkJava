package JavaIo.Demo.BasicIO_01;

import java.io.File;

/**
 * Created by jon on 17-1-4.
 */
public class MakeDirectories {
    private static void usage() {
        System.err.println("Usage:MakeDirectories path1...\n" +
                "Creates each path\n" +
                "Usage:MakeDirectories -d path1...\n"
                + "Deletes each path\n" +
                "Usage:MakeDirectories-r path1 path2\n"
                + "Renames form path1 to path2"
        );
        System.exit(1);
    }

    private static void fileData(File f) {
        System.out.println("Absolute path: " + f.getAbsolutePath() +
                f.getAbsolutePath() +
                "\n Can read: " + f.canRead() +
                "\n Can write: " + f.canWrite() +
                "\n getName: " + f.getName() +
                "\n getParent: " + f.getParent() +
                "\n length:" + f.length() +
                "\n lastModified: " + f.lastModified()
        );
        if (f.isFile())
            System.out.println("It's a file");
        else if (f.isDirectory())
            System.out.println("It's a directory");
    }

    public static void main(String[] args) {
        if (args.length < 1) usage();
        if (args[0].equals("-r")) {             //第一个参数-r时走这里
            File
                    old = new File(Constants.homePath + args[1]),
                    rname = new File(Constants.homePath + args[2]);
            old.renameTo(rname);
            fileData(old);
            fileData(rname);
            return; //Exit main
        }
        int count = 0;
        boolean del = false;
        if (args[0].equals("-d")) {
            count++;
            del = true;
        }
        count--;
        while (++count < args.length) {
            File f = new File(Constants.homePath + args[count]);
            if (f.exists()) {
                System.out.println(f + " exists");
                if (del) {
                    System.out.println("deleting..." + f);
                    f.delete();
                }
            } else {   //Doesn't exist
                if (!del) {
                    f.mkdirs();
                    System.out.println("created " + f);
                }
            }
            fileData(f);
        }
    }
}
