package JavaIo.Demo.NewIO_02;


import JavaIo.Utils.Constants;

import java.io.*;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by jon on 16-4-4.
 * 18.10.6性能
 */
public class MappedIO {
    private static int numofInts = 4000000;
    private static int numOfUbunffInts = 200000;
    private static String path = Constants.writePathU + "temp.tmp";

    private abstract static class Tester {
        private String name;

        public Tester(String name) {
            this.name = name;
        }


        public void runTest() {
            System.out.print(name + ": ");
            try {
                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.format("%.2f\n", duration / 1.0e9);
            } catch (IOException e) {
                new RuntimeException(e);
            }
        }

        public abstract void test() throws IOException;
    }


    private static Tester[] tests = {
            new Tester("String Write") {
                @Override
                public void test() throws IOException {
                    DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(
                            new File(path))));
                    for (int i = 0; i < numofInts; i++)
                        dos.writeInt(i);
                    dos.close();
                }
            },

            new Tester("Mapped Write") {
                @Override
                public void test() throws IOException {
                    FileChannel fc = new RandomAccessFile(path, "rw").getChannel();
                    IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                    for (int i = 0; i < numofInts; i++)
                        ib.put(i);
                    fc.close();
                }
            }
            ,
            new Tester("Stream Read") {
                @Override
                public void test() throws IOException {
                    DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(path)));
                    for (int i = 0; i < numofInts; i++)
                        dis.readInt();
                    dis.close();
                }
            }
            ,
            new Tester("Mapped Read") {
                @Override
                public void test() throws IOException {
                    FileChannel fc = new FileInputStream(new File(path)).getChannel();
                    MappedByteBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
                    while (ib.hasRemaining())
                        ib.get();
                    fc.close();
                }
            }
            ,
            new Tester("Stream Read/Write") {
                @Override
                public void test() throws IOException {
                    RandomAccessFile raf = new RandomAccessFile(new File(path), "rw");
                    raf.writeInt(1);
                    for (int i = 0; i < numOfUbunffInts; i++) {  //这个循环咋起作用
                        raf.seek(raf.length() - 4);
                        raf.writeInt(raf.readInt());
                    }
                    raf.close();
                }
            }
            ,
            new Tester("Mapped Read/Write") {
                @Override
                public void test() throws IOException {
                    FileChannel fc = new RandomAccessFile(new File(path), "rw").getChannel();
                    IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                    ib.put(0);
                    for (int i = 1; i < numOfUbunffInts; i++)
                        ib.put(ib.get(i - 1));
                    fc.close();

                }
            }

    };


    public static void main(String[] args) {
        for (Tester test : tests) {
            test.runTest();
        }
    }


}
