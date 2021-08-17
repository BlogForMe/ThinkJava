package algorlthm.learn.rank;


public class SelectionSort {

    //选择排序
    public static void selectionSort(int[] arr) {
        int maxIndex;
        int tmp;
        for (int i = arr.length - 1; i > 0; i--) {
            maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = tmp;
        }
    }
}
