package JavaIo.Demo.BasicIO_01;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by jon on 16-4-2.
 */
public class BinaryFile {
    public static byte[] read(File bFile) throws IOException {
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bFile));
        byte[] data = new byte[bf.available()];
        bf.read(data);
        return data;
    }

    public static byte[] read(String bFile) throws IOException {
        return read(new File(bFile).getAbsoluteFile());
    }

}
