package datastruct.resume.rank;

//https://segmentfault.com/a/1190000017301113
public class HeapSort {
    public static void heapSort(int[] arr) {
        buildHeap(arr, arr.length); //建堆
        selectSorted(arr); // 交换 下滤
    }

    private static void buildHeap(int[] arr, int length) {
        for (int k = (length - 1) >> 1; k >= 0; k--) {  //最后的内部节点 往前遍历
            addJustHeap(arr, k, length);
        }
    }

    private static void addJustHeap(int[] arr, int k, int length) {
        for (int i = 2 * k + 1; i <= length; i = 2 * i + 1) { // 上面节点调整后，可能比子节点还小，需要继续调整
            if ((i + 1) < length && arr[i] < arr[i + 1]) {
                i++; // 左子树比右子树小，用右子树比较
            }

            if (i < length && arr[k] < arr[i]) {
                swap(arr, k, i);
                k = i;
            }
        }
    }

    private static void selectSorted(int[] arr) {
        for (int j = 0; j < arr.length - 1; j++) {
//            System.out.println("a[0]    " + arr[0]);
            swap(arr, 0, arr.length - 1 - j); //交换到已排序位置
//            System.out.print("交换后     ");
//            Print.printArr(arr);
            addJustHeap(arr, 0, arr.length - 1 - j); //继续调整
//            System.out.print("重新调整后 ");
//            Print.printArr(arr);
        }
    }

    private static void swap(int[] arr, int k, int i) {
        int tmp = arr[i];
        arr[i] = arr[k];
        arr[k] = tmp;
    }


}
