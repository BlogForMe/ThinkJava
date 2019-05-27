package JavaIo.Demo.BasicIO_01;

import JavaIo.Utils.Constants;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * 有问题
 * Created by jon on 16-4-2.
 * 18.7
 * 文件读写实用工具
 */
public class TextFile extends ArrayList<String> {
    /**
     * 读取一个文件
     *
     * @param filename
     * @return Read a file as a single string:
     */
    public static String read(String filename) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(new File(filename).getAbsoluteFile()))) {
            String s;
            while ((s = in.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    /**
     * 写入一个文件
     *
     * @param filename
     * @param text     Write a single file in one method call:
     */
    public static void write(String filename, String text) {
        try (PrintWriter out = new PrintWriter(new File(filename).getAbsoluteFile())) {
            out.print(text);
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));  //把每一行放到Array里
        //Regular expression split() often leaves an empty
        //String at the first position
        if (get(0).equals("")) remove(0);
    }

    //Normally read by lines:
    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public void write(String fileName) {
        try (PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile())) {
            for (String item : this) {
                out.println(item);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String file = read(JavaIo.Utils.Constants.hPBasic + "TextFile.java");
        write((Constants.writePathW + "text.txt"), file);


        TextFile text = new TextFile(Constants.writePathW + "text.txt");
        text.write(Constants.writePathW + "text2.txt");
        //Break into unique sorted list of words;
        TreeSet<String> words = new TreeSet<>(new TextFile(JavaIo.Utils.Constants.hPBasic + "TextFile.java", "\\W+"));
        //Display the capitalized words:
        System.out.print(words.headSet("a"));  //这句意思应该是返回 比 a  小的部分
//        for (String s : words) {
//            System.out.println(s);
//        }
    }
}
