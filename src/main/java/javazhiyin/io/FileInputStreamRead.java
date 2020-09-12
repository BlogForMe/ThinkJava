package javazhiyin.io;


import java.io.*;

/**
 * https://www.javazhiyin.com/17362.html
 */
public class FileInputStreamRead {
    public static void main(String[] args) {

      /*  FileInputStream fis = null;
        try {
            fis = new FileInputStream("/Users/john/Documents/jywork/THINKJAVA/src/main/resource/a.txt");
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data+"  ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

      /*  try {
            FileInputStream fis = new FileInputStream("/Users/john/Documents/jywork/THINKJAVA/src/main/resource/a.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);
            int data;
            while ((data = bufferedInputStream.read()) != -1) {
                System.out.print((char) data+"  ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        FileInputStream fis = null;
        try {
            byte[] bytes = new byte[14];
            fis = new FileInputStream("/Users/john/Documents/jywork/THINKJAVA/src/main/resource/a.txt");
            int read = fis.read(bytes,0,4);
            String s  = new String(bytes);
            System.out.println(s);
            System.out.println(read);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        try {
//            FileReader fileReader = new FileReader("/Users/john/Documents/jywork/THINKJAVA/src/main/resource/a.txt");
////            System.out.println((char)fileReader.read());
//            int data;
//            while ((data = fileReader.read()) != -1) {
//                System.out.print((char) data+"  ");
//            }
//
//        } catch (FileNotFoundException e) {
//
//        } catch (IOException e) {
//
//        }


//        char[] c = new char[64];
//        FileReader fis = null;
//        try {
//            fis = new FileReader("/Users/john/Documents/jywork/THINKJAVA/src/main/resource/a.txt");
//            int read = fis.read(c);
//            System.out.println(new String(c));
//            System.out.println(read);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
