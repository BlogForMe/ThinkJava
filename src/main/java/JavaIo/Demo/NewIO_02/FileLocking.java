package JavaIo.Demo.NewIO_02;


import JavaIo.Utils.Constants;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * Created by jon on 16-4-5.
 * 18.10.7文件加锁
 */
public class FileLocking {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream(Constants.writePathU + "file.txt");
        FileLock fi = fos.getChannel().tryLock();
        if (fi != null) {
            System.out.println("Lock File");
            TimeUnit.MILLISECONDS.sleep(100);
            fi.release();
            System.out.println("Release lock");
        }
        fos.close();
    }
}
