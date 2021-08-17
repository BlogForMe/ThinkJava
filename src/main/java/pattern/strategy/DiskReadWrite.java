package pattern.strategy;

/**
 * 磁盘读写处理
 */
public class DiskReadWrite<T> implements IReadWrite<T> {
    @Override
    public T read() {
        Object object = "从磁盘读取数据";
        return (T) object;
    }

    @Override
    public boolean write(T data) {
        System.out.println("磁盘写入 " + data + " 完成");
        return true;
    }
}
