package algorlthm.learn.rank;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) { //剩余需要排序的长度
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }


    public static void bubbleSort2(int[] arr) {
        boolean swap;
        for (int i = arr.length - 1; i > 0; i--) { //剩余需要排序的长度
            swap = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }

}
