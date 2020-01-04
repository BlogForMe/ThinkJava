package JavaIo.Test.filem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2016/11/23.
 */
public class MusicMofify {
    static String mInPath = "D:\\File\\CloudMusic\\刘若英 - 原来你也在这里.mp3";
    static String mOutPath = "C:\\Users\\Administrator\\Desktop\\刘落英.mp3";


    public static void main(String[] args) {
        coryMusic();
    }

    private static void coryMusic() {
        try {
            FileInputStream fis = new FileInputStream(mInPath);
            FileOutputStream fos = new FileOutputStream(mOutPath);

            byte[] b = new byte[1024];
            int i;
            while ((i = fis.read(b)) != -1) {
                fos.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
