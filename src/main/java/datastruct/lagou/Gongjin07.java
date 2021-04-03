package datastruct.lagou;

public class Gongjin07 {
    public static void main(String[] args) {
        int[] arr = {6, 9, 3, 8, 10};

        int maxScore = arr[0];
        int minScore = arr[0];
        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > maxScore) {
                maxScore = arr[i];
                maxIndex = i;
            }
            if (arr[i] < minScore) {
                minScore = arr[i];
                minIndex = i;
            }
        }

        arr[maxIndex] = 0;
        arr[minIndex] = 0;

        int sum=0;
        for (int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        System.out.println(sum/3);
    }
}
