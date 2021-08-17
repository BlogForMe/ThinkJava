package pattern.strategy;


/**
 * 磁盘读写处理
 */
public class DbReadWrite<T> implements IReadWrite<T> {
    @Override
    public T read() {
        Object object = "从数据库读取数据";
        return (T) object;
    }

    @Override
    public boolean write(T data) {
        System.out.println("数据库写入 " + data + " 完成");
        return true;
    }
}
