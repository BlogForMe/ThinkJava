package pattern.strategy;

public interface IReadWrite<T> {
    T read();

    boolean write(T data);
}
