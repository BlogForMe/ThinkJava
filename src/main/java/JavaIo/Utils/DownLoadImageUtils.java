package JavaIo.Utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by Jon on 2016/9/12.
 * 图片下载工具
 */

public class DownLoadImageUtils {


    /**
     * 根据url下载图片在指定的文件
     * @param urlStr
     * @param file
     * @return
     */
    public static boolean downloadImgByUrl(String urlStr, File file) {
        FileOutputStream fos = null;
        InputStream is = null;
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            is = conn.getInputStream();
            fos = new FileOutputStream(file);
            byte[] buf = new byte[512];
            int len = 0;
            while ((len = is.read(buf)) != -1) {
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

    /**
     * 根据picUrl下载图片到filePath
     *
     * @param picUrl
     * @param filePath
     */
    public static boolean downloadImgByUrl(String picUrl, String filePath) {
        byte[] btImg = getImageFromByUrl(picUrl);
        if (null != btImg && btImg.length > 0) {
            return writeByteToDisk(btImg, filePath);
        }
        return false;
    }

    /**
     * 将图片写入到磁盘
     *
     * @param btImg
     * @param filePath
     */
    public static Boolean writeByteToDisk(byte[] btImg, String filePath) {
        FileOutputStream fos = null;
        try {
            File file = new File(filePath);
            fos = new FileOutputStream(filePath);
            fos.write(btImg);
            fos.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            try {
                fos.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 根据地址获得数据的字节流
     *
     * @param picUrl
     * @return
     */
    public static byte[] getImageFromByUrl(String picUrl) {
        byte[] btImg = null;
        try {
            URL url = new URL(picUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
            btImg = readInputStream(inStream);  //得到图片的二进制数据
            return btImg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return btImg;
    }

    /**
     * 从输入流中获取数据
     *
     * @param inStream
     * @return
     */
    private static byte[] readInputStream(InputStream inStream) {
        ByteArrayOutputStream outStream = null;
        try {
            outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[512];
            int len = 0;
            while ((len = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            inStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return outStream.toByteArray();

    }


}
