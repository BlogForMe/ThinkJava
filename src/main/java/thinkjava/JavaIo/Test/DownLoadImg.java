package thinkjava.JavaIo.Test;

import thinkjava.JavaIo.Demo.BasicIO_01.Constants;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/9/14.
 */
public class DownLoadImg {
    public static void main(String[] args) {
        String picUrl = "http:/pic.klsds.com/files/ads/2016-08/2e7843b14ca60fa5931eb1bc97c69dd6.jpg";
        boolean flag = downloadImgByUrl(picUrl, Constants.homepathW + "img.jpg");
        System.out.println(flag);
    }

    /**
     * 根据picUrl下载图片到filePath
     *
     * @param picUrl
     * @param filePath
     */
    public static boolean downloadImgByUrl(String picUrl, String filePath) {
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL(picUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            is = conn.getInputStream();
            fos = new FileOutputStream(new File(filePath));
            byte[] buf = new byte[512];
            int len = 0;
            while ((len = is.read()) != -1) {
                fos.write(buf, 0, len);
            }
            fos.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
            }
        }
        return false;
    }
}
