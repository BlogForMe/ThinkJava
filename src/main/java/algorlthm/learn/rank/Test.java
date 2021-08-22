package algorlthm.learn.rank;

import util.Print;

public class Test {

    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
//        BubbleSort.bubbleSort(arr);
//        BubbleSort.bubbleSort2(arr);
//          SelectionSort.selectionSort(arr);

        QuickSort.quickSort(arr,0,arr.length-1);

//        int[] arr = {87, 45, 78, 32, 17, 65, 53, 9, 122, 133};

        Print.printArr(arr);
        HeapSort.heapSort(arr);

        Print.printArr(arr);


//        Print.printArr(arr);
    }

}
