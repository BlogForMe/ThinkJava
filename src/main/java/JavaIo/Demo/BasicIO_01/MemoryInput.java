package JavaIo.Demo.BasicIO_01;

import java.io.IOException;

/**
 * Created by jon on 16-4-2.
 * 18.6.2
 * 从内存中输入
 */
public class MemoryInput {
    public static void main(String[] args) {
        try {

            String filename = Constants.path + "MemoryInput.java";
            String input = BufferedInputFile.read(filename);
            System.out.println(input);
        } catch (IOException ex) {
            System.out.println(ex);
        }


    }
}
