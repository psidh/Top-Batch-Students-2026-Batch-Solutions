import java.util.Arrays;

class Merge {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        mergeSort(arr, 0, 4);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    static void merge(int[] arr, int low, int mid, int high) {
        int[] merged = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                merged[k++] = arr[i++];
            } else {
                merged[k++] = arr[j++];
            }
        }

        while (i <= mid)
            merged[k++] = arr[i++];
        while (j <= high)
            merged[k++] = arr[j++];
                
        for (int x = 0; x < merged.length; x++) {
            arr[low + x] = merged[x];
        }
    }
}