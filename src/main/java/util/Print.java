package util;

import java.util.Arrays;
import java.util.List;

public class Print<T> {
    public static void printArr(int[] arr) {
        Arrays.stream(arr).forEach(data -> System.out.print(data + " "));
        System.out.println();
    }
    public static void printArr(List<String> list) {
        list.stream().forEach(data->System.out.print(data + " "));
        System.out.println();
    }

    public   void print(T[] arr) {
        Arrays.stream(arr).forEach(data -> System.out.print(data + " "));
        System.out.println();
    }
}
