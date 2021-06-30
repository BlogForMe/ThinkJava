package datastruct.resume.rank;

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
            while (lo<hi&&elem[hi] >= pivot) hi--;
                elem[lo] = elem[hi];
            while (lo<hi&&elem[lo] < pivot) lo++;
                elem[hi] = elem[lo];
        }
        elem[lo]= pivot;
        return lo;
    }

}
