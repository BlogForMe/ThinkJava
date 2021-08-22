package algorlthm.learn.rank;

/**
 * 快速排序
 * https://noteforme.github.io/2021/03/21/Data-Sort/
 */
public class QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mi = partition(arr, left, right);
        quickSort(arr, left, mi - 1);
        quickSort(arr, mi + 1, right);
    }

    private static int partition(int[] elem, int left, int right) {
        int pivot = elem[left];
        while (left < right) {
            while (left < right && elem[right] >= pivot) {
                right--;  //右边的数据大于基准点，往前比较
            }
            if (left < right) {   // 当小于基准点时，把数据放到缺口处
                elem[left] = elem[right];
            }
            while (left < right && elem[left] <= pivot) {
                left++;  // 左边开始比较，当小于基准点时,向后比较
            }

            if (left < right) {   // 当小于基准点时，把数据放到缺口处
                elem[right] = elem[left];
            }

            if (left >= right) {
                elem[right] = elem[left];               // 当大于基准点，放到右边的缺口处
            }
        }
        elem[left] = pivot;                           //最终的值就是基准点
        return left;
    }

}
