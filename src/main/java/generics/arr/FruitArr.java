package generics.arr;

import java.lang.reflect.Array;

public class FruitArr<T> {
    private T[] array;

    public FruitArr(Class<T> clz, int length) {
        this.array = (T[]) Array.newInstance(clz, length);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index){
        return array[index];
    }

    public T[] getArray(){
        return array;
    }
}
