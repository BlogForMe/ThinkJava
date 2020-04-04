package thinkjava.JavaIo.Demo.ZIP_03;

import thinkjava.JavaIo.Utils.Constants;
import thinkjava.net.mindview.util.Print;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * Created by Jon on 2016/5/27.
 * 18.11.2   用ZIP进行多文件保存
 */
public class ZipCompress {
    public static void main(String[] args) throws IOException {
        FileOutputStream f = new FileOutputStream(Constants.writePathU + "thinkjava.test.zip");
        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);
        zos.setComment("A thinkjava.test of Java Zipping");

        args = new String[]{Constants.writePathU + "thinkjava.test.zip"};

        //No corresponding getComment() ,though
        for (String arg : args) {
            Print.print("Writing file " + arg);
            BufferedReader in = new BufferedReader(new FileReader(arg));
            zos.putNextEntry(new ZipEntry(arg));
            int c;
            while ((c = in.read()) != -1)
                out.write(c);
            in.close();
            out.flush();
        }
        out.close();
        //Checksum valid only after the file has been closed!
        Print.print("Checksum : " + csum.getChecksum().getValue());

        //Now extract the files:
        Print.print("Reading file");
        FileInputStream fi = new FileInputStream(Constants.writePathU + "thinkjava.test.zip");

        CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
        ZipInputStream in2 = new ZipInputStream(csumi);
        BufferedInputStream bis = new BufferedInputStream(in2);
        ZipEntry ze;
        while ((ze = in2.getNextEntry()) != null) {
            Print.print("Reading file " + ze);
            int x;
            while ((x = bis.read()) != -1)
                System.out.write(x);
        }
        if (args.length == 1)
            Print.print("Checksum: " + csumi.getChecksum().getValue());
        bis.close();
        //Alternative way to open and read Zip files:
        ZipFile zf = new ZipFile(Constants.writePathU + "thinkjava.test.zip");
        Enumeration e = zf.entries();
        while (e.hasMoreElements()) {
            ZipEntry ze2 = (ZipEntry) e.nextElement();
            Print.print("File: " + ze2);
            //... and extract the data as before
        }

    }
}
