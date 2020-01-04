package JavaConcurrency.demo.ShareResources_02;

/**
 * Created by Jon on 2016/5/1.
 * 21.3.1不正确的访问资源
 */
abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();
    //allow thid to be canceled

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }

}