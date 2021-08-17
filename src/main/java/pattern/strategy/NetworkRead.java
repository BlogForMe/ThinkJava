package pattern.strategy;


/**
 * 网络读写处理
 */
public class NetworkRead<T> implements IReadWrite<T> {
    @Override
    public T read() {
        Object object = "从网络读取数据";
        return (T) object;
    }

    @Override
    public boolean write(T data) {
        throw new RuntimeException("暂不支持网络存储");
    }
}
