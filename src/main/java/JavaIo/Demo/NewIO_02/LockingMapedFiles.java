package JavaIo.Demo.NewIO_02;

import JavaIo.Demo.BasicIO_01.Constants;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by jon on 16-4-5.
 * 18.10.7对映射文件的部分加锁
 */
public class LockingMapedFiles {
    static final int LENGTH = 0X8FFFFFF; //128M
    static FileChannel fc;

    public static void main(String[] args) throws Exception {
        fc = new RandomAccessFile(Constants.homePath + "test.dat", "rw").getChannel();
        MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        for (int i = 0; i < LENGTH; i++)
            out.put((byte) 'x');
        new LockAndModify(out, 0, 0 + LENGTH / 3);
        new LockAndModify(out, LENGTH / 2, LENGTH / 2 + LENGTH / 4);
    }

    private static class LockAndModify extends Thread {
        private ByteBuffer buff;
        private int start, end;

        public LockAndModify(ByteBuffer mbb, int start, int end) {
            this.buff = mbb.slice();
            this.end = end;
            this.start = start;
            mbb.position(start);
            start();
        }

        @Override
        public void run() {
            try {
                //Exclusive lock with no overlap:
                FileLock fl = fc.lock(start, end, false);
                System.out.println("Locked: " + start + " to " + end);
                //Perform modification:
                while (buff.position() < buff.limit() - 1)
                    buff.put((byte) (buff.get() + 1));
                fl.release();
                System.out.println("Released: " + start + " to " + end);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
