package JavaIo.Exercise;

import JavaIo.Demo.BasicIO_01.BinaryFile;
import JavaIo.Demo.BasicIO_01.Directory;
import JavaIo.Utils.Constants;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/1/6.
 */
public class E21_CheckOx {
    final static byte[] signature = {(byte) 254, (byte) 186, (byte) 190};

    public static void main(String[] args) throws IOException {
        for (File file : Directory.walk(Constants.hPExercise, ".*")) {
            byte[] bt = BinaryFile.read(file);
            for (int i = 0; i < signature.length; i++)
                if (bt[i] != signature[i]) {
                    System.err.println(false + "is corrupt!");
                    break;
                }
        }

    }
}
