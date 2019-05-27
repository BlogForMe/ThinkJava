package JavaIo.Demo.ZIP_03;


import JavaIo.Utils.Constants;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by Jon on 2016/5/27.
 * 18.11.1用GZIP进行简单压缩
 */
public class GZIPcompress {
    public static void main(String[] args) throws IOException {
//        if (args.length == 0) {
//            System.out.println("Usage : \nGZIPcompress file\n" + "\tUses GZIP compression to compress" + "the file to test.gz");
//            System.exit(1);
//        }
        args = new String[]{Constants.homePathU + "Demo/ZIP_03/GZIPcompress.java"};
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(Constants.writePathU + "test.gz")));
        System.out.println("Writing file");
        int c;
        while ((c = in.read()) != -1)
            out.write(c);
        in.close();
        out.close();
        System.out.println("Reading file");
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(Constants.writePathU + "test.gz"))));
        String s;
        while ((s = in2.readLine()) != null)
            System.out.println(s);


    }
}
