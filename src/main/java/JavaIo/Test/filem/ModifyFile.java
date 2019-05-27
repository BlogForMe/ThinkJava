package JavaIo.Test.filem;

import java.io.*;

/**
 * Created by Administrator on 2016/11/22.
 * 修改文件
 */
public class ModifyFile {
    static String filePath = "D:\\File\\";

    public static void main(String[] args) {

//        fileReader();

//        bufferIo();

        inputStreamIo();


    }

    private static void fileReader() {
        try {
            FileReader fr = new FileReader(filePath + "android.in");
            FileWriter fos = new FileWriter(filePath + "android.out");

            int str;
            while ((str = fr.read()) != -1) {
                System.out.println((char) str);
                fos.write(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void inputStreamIo() {
        try {
            FileInputStream fis = new FileInputStream(filePath + "android.in");
            FileOutputStream fos = new FileOutputStream(filePath + "android.out");
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                fos.write(b,0,9);
            }
        } catch (IOException e) {

        }

    }


    private static void bufferIo() {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(filePath + "android.in")));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath + "android.out")));
            String s;
            while ((s = bf.readLine()) != null) {
//                if (s.contains("1.1")){
//                    s.replace("1.1","1.5");
//                }
                bw.write(s);
                System.out.println(s);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
