package pattern.Decorator;

import java.io.*;

public class LowerCaseInputStream extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }

    public int read() throws IOException {
        int c = super.read();
        return (c==-1?c:Character.toLowerCase(c));
    }

    public int read(byte[] b,int offset,int len) throws IOException {
        int result = super.read(b, offset, len);
        for (int i=offset;i<offset+result;i++){
            b[i] = (byte)Character.toLowerCase(b[i]);
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        int c;

        FileInputStream in1 = new FileInputStream("test.txt");
        LowerCaseInputStream in = new LowerCaseInputStream(in1);
        BufferedInputStream bin = new BufferedInputStream(in);

        while ((c=bin.read())>=0){
            System.out.print((char) c);
        }

    }
}
