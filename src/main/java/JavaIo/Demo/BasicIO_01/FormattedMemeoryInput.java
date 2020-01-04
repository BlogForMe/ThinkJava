package JavaIo.Demo.BasicIO_01;

import JavaIo.Utils.Constants;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * Created by Administrator on 2017/1/5.
 */
public class FormattedMemeoryInput {
    public static void main(String[] args) throws IOException {
        try {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read(Constants.hPBasic + "FormattedMemeoryInput.java").getBytes()));
            while (true)
                System.out.print((char) in.readByte());
        } catch (EOFException e) {
            System.err.print("End of stream");
        }
    }
}
