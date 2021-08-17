package algorlthm.learn.rank;

/**
 * 快速排序
 * https://noteforme.github.io/2021/03/21/Data-Sort/
 */
public class QuickSort {
    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo>=hi) return;
        int mi = partition(arr, lo, hi);
        quickSort(arr, lo, mi-1);
        quickSort(arr, mi + 1, hi);
    }

    private static int partition(int[] elem, int lo, int hi) {
        int pivot = elem[lo];
        while (lo < hi) {
            while (lo<hi&&elem[hi] >= pivot) hi--;  //右边的数据大于基准点，往前比较
                elem[lo] = elem[hi];               // 当小于基准点时，把数据放到缺口处
            while (lo<hi&&elem[lo] < pivot) lo++;  // 左边开始比较，当小于基准点时,向后比较
                elem[hi] = elem[lo];               // 当大于基准点，放到右边的缺口处
        }
        elem[lo]= pivot;                           //最终的值就是基准点
        return lo;
    }

}
