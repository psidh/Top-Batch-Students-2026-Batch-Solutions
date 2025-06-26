public class Quick {

    public static void main(String[] args) {
        int[] arr = { 8, 7, 6, 5, 4, 3, 2, 1 };
        quickSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex);
            quickSort(arr, pivotIndex + 1, high);

        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (true) {
            while (i <= high && arr[i] < pivot) {
                i++;
            }
            while (j >= low && arr[j] > pivot) {
                j--;
            }

            if (i >= j)
                return j;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }
}
